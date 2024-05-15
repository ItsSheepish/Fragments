package its.sheepish.fragments.blocks.entity;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.blocks.custom.SoulInfuserBlock;
import its.sheepish.fragments.items.ModItems;
import its.sheepish.fragments.items.custom.DiamondShearsItem;
import its.sheepish.fragments.items.custom.SoulItem;
import its.sheepish.fragments.recipe.SoulInfuserRecipe;
import its.sheepish.fragments.screen.SoulInfuserScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SoulInfuserBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);

    private static final int SOUL1_INPUT_SLOT = 0;
    private static final int SOUL2_INPUT_SLOT = 1;
    private static final int SOUL3_INPUT_SLOT = 2;
    private static final int SOUL4_INPUT_SLOT = 3;
    private static final int EGG_INPUT_SLOT = 4;
    private static final int OUTPUT_SLOT = 5;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 2400;

    public SoulInfuserBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SOUL_INFUSER_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> SoulInfuserBlockEntity.this.progress;
                    case 1 -> SoulInfuserBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> SoulInfuserBlockEntity.this.progress = value;
                    case 1 -> SoulInfuserBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 5;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("soul_infuser_block");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("soul_infuser.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        nbt.getInt("soul_infuser.progress");
    }

    public ItemStack getRenderStack() {
        if(this.getStack(OUTPUT_SLOT).isEmpty()) {
            return this.getStack(EGG_INPUT_SLOT);
        } else {
            return this.getStack(OUTPUT_SLOT);
        }
    }
    public ItemStack getRenderStack1() {
        return this.getStack(SOUL1_INPUT_SLOT);
    }
    public ItemStack getRenderStack2() {
        return this.getStack(SOUL2_INPUT_SLOT);
    }
    public ItemStack getRenderStack3() {
        return this.getStack(SOUL3_INPUT_SLOT);
    }
    public ItemStack getRenderStack4() {
        return this.getStack(SOUL4_INPUT_SLOT);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new SoulInfuserScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(isOutputSlotEmptyOrReceivable()) {
            if(this.hasRecipe()) {
                this.increaseCraftProgress();
                markDirty(world, pos, state);

                if(hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<RecipeEntry<SoulInfuserRecipe>> recipe = getCurrentRecipe();
        this.removeStack(EGG_INPUT_SLOT, 1);
        this.removeStack(SOUL1_INPUT_SLOT, 1);
        this.removeStack(SOUL2_INPUT_SLOT, 1);
        this.removeStack(SOUL3_INPUT_SLOT, 1);
        this.removeStack(SOUL4_INPUT_SLOT, 1);

        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<SoulInfuserRecipe>> recipe = getCurrentRecipe();

        return recipe.isPresent() &&
                canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null)) &&
                canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeEntry<SoulInfuserRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for(int i = 0; i < this.size(); i++) {
            inv.setStack(i, this.getStack(i));
        }

        return getWorld().getRecipeManager().getFirstMatch(SoulInfuserRecipe.Type.INSTANCE, inv, getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
}
