package its.sheepish.fragments.items.custom;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.enchantments.ModEnchantments;
import its.sheepish.fragments.items.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class DiamondShearsItem extends Item {

    private final int randomValue;

    public DiamondShearsItem(Settings settings, int random, String type) {
        super(settings);
        this.randomValue = random;
        Fragments.LOGGER.info("Making the new " + type + " shears for "+Fragments.MOD_ID);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        int shearLevel = EnchantmentHelper.getLevel(ModEnchantments.SHEARING, user.getStackInHand(hand));
        if (hand == Hand.MAIN_HAND && user.getStackInHand(Hand.OFF_HAND).getItem() == Items.DIAMOND) {
            playSwingAnimation(user, hand);
            if (!user.getWorld().isClient) {
                givePlayerAnotherItem(user, shearLevel);
                stack.damage(1, user, (entity) -> entity.sendToolBreakStatus(hand));
                user.getStackInHand(Hand.OFF_HAND).decrement(1);
            }
        } else if (hand == Hand.OFF_HAND && user.getStackInHand(Hand.MAIN_HAND).getItem() == Items.DIAMOND) {
            playSwingAnimation(user, hand);
            if (!user.getWorld().isClient) {
                givePlayerAnotherItem(user, shearLevel);
                stack.damage(1, user, (entity) -> entity.sendToolBreakStatus(hand));
                user.getStackInHand(Hand.MAIN_HAND).decrement(1);
            }
        }
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && !state.isIn(BlockTags.FIRE)) {
            stack.damage(1, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }

        return state.isIn(BlockTags.LEAVES) || state.isOf(Blocks.COBWEB) || state.isOf(Blocks.GRASS) || state.isOf(Blocks.FERN) || state.isOf(Blocks.DEAD_BUSH) || state.isOf(Blocks.HANGING_ROOTS) || state.isOf(Blocks.VINE) || state.isOf(Blocks.TRIPWIRE) || state.isIn(BlockTags.WOOL) || super.postMine(stack, world, state, pos, miner);
    }
    public boolean isSuitableFor(BlockState state) {
        return state.isOf(Blocks.COBWEB) || state.isOf(Blocks.REDSTONE_WIRE) || state.isOf(Blocks.TRIPWIRE);
    }
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (!state.isOf(Blocks.COBWEB) && !state.isIn(BlockTags.LEAVES)) {
            if (state.isIn(BlockTags.WOOL)) {
                return 5.0F;
            } else {
                return !state.isOf(Blocks.VINE) && !state.isOf(Blocks.GLOW_LICHEN) ? super.getMiningSpeedMultiplier(stack, state) : 2.0F;
            }
        } else {
            return 15.0F;
        }
    }
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        if (block instanceof AbstractPlantStemBlock abstractPlantStemBlock) {
            if (!abstractPlantStemBlock.hasMaxAge(blockState)) {
                PlayerEntity playerEntity = context.getPlayer();
                ItemStack itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity) {
                    Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
                }

                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_GROWING_PLANT_CROP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                BlockState blockState2 = abstractPlantStemBlock.withMaxAge(blockState);
                world.setBlockState(blockPos, blockState2);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(context.getPlayer(), blockState2));
                if (playerEntity != null) {
                    itemStack.damage(1, playerEntity, (player) -> {
                        player.sendToolBreakStatus(context.getHand());
                    });
                }

                return ActionResult.success(world.isClient);
            }
        }

        return super.useOnBlock(context);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity) {
            SheepEntity sheep = (SheepEntity) entity;
            if (!sheep.isSheared() && sheep.isAlive()) {
                sheep.setSheared(true);
                int shearedColor = sheep.getColor().getId();
                Item woolItem = getWoolItemByColor(shearedColor); // Function to get wool item by color
                if (woolItem != null) {
                    ItemStack woolStack = new ItemStack(woolItem);
                    int fortuneLevel = EnchantmentHelper.getLevel(ModEnchantments.SHEARING, user.getStackInHand(hand));
                    woolStack.setCount(getRandomNumber(randomValue, randomValue+2)+fortuneLevel);
                    ItemEntity woolEntity = new ItemEntity(sheep.getWorld(), sheep.getX(), sheep.getY(), sheep.getZ(), woolStack);
                    woolEntity.setToDefaultPickupDelay(); // Make it immediately collectible
                    sheep.getWorld().spawnEntity(woolEntity);
                    stack.damage(1, user, (player) -> player.sendToolBreakStatus(hand));
                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }

    private void playSwingAnimation(PlayerEntity player, Hand hand) {
        player.swingHand(hand);
    }
    private Item getWoolItemByColor(int colorId) {
        DyeColor dyeColor = DyeColor.byId(colorId);
        switch (dyeColor) {
            case WHITE:
                return Items.WHITE_WOOL;
            case ORANGE:
                return Items.ORANGE_WOOL;
            case MAGENTA:
                return Items.MAGENTA_WOOL;
            case LIGHT_BLUE:
                return Items.LIGHT_BLUE_WOOL;
            case YELLOW:
                return Items.YELLOW_WOOL;
            case LIME:
                return Items.LIME_WOOL;
            case PINK:
                return Items.PINK_WOOL;
            case GRAY:
                return Items.GRAY_WOOL;
            case LIGHT_GRAY:
                return Items.LIGHT_GRAY_WOOL;
            case CYAN:
                return Items.CYAN_WOOL;
            case PURPLE:
                return Items.PURPLE_WOOL;
            case BLUE:
                return Items.BLUE_WOOL;
            case BROWN:
                return Items.BROWN_WOOL;
            case GREEN:
                return Items.GREEN_WOOL;
            case RED:
                return Items.RED_WOOL;
            case BLACK:
                return Items.BLACK_WOOL;
            default:
                return Items.WHITE_WOOL; // Default to white wool
        }
    }

    private int getRandomNumber(int random, int random2) {
        return Random.createLocal().nextBetween(random, random2);
    }

    private void givePlayerAnotherItem(PlayerEntity player, int level) {
        int fragmentIncrease = 0;
        if (level == 3) {
            int random = getRandomNumber(1,100);
            if (random >= 95) {
                fragmentIncrease = 1;
            }
        }
        ItemStack newItemStack = new ItemStack(ModItems.DiamondFragment, 9+fragmentIncrease);
        player.giveItemStack(newItemStack);
    }
}
