package its.sheepish.fragments.action;

import its.sheepish.fragments.enchantments.ModEnchantments;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ShearingEnchantmentHandler {
    public static void registerEventHandler() {
        UseEntityCallback.EVENT.register(ShearingEnchantmentHandler::onShearSheep);
    }

    public static ActionResult onShearSheep(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        // Check if the entity is a sheep and the player is holding shears
        if (!world.isClient) {
            if (entity instanceof SheepEntity && player.getStackInHand(hand).getItem() == Items.SHEARS) {
                SheepEntity sheep = (SheepEntity) entity;
                // Check if the sheep can be sheared
                if (!sheep.isSheared() && sheep.isAlive()) {
                    // Your custom logic here
                    int shearLevel = EnchantmentHelper.getLevel(ModEnchantments.SHEARING, player.getStackInHand(hand));
                    if (player.getStackInHand(hand).hasEnchantments() && shearLevel > 0) {
                        // Drop additional shears
                        int shearedColor = sheep.getColor().getId();
                        Item woolItem = getWoolItemByColor(shearedColor);
                        if (woolItem != null) {
                            sheep.setSheared(true);
                            ItemStack woolStack = new ItemStack(woolItem);
                            int amount = getRandomNumber(1,3);
                            int amountIncreaser = getRandomNumber(1, shearLevel);
                            woolStack.setCount(amount + amountIncreaser);
                            ItemEntity woolEntity = new ItemEntity(sheep.getWorld(), sheep.getX(), sheep.getY(), sheep.getZ(), woolStack);
                            woolEntity.setToDefaultPickupDelay(); // Make it immediately collectible
                            sheep.getWorld().spawnEntity(woolEntity);
                            return ActionResult.SUCCESS;
                        }
                    }
                    // Returning PASS allows the vanilla shearing behavior to proceed
                    return ActionResult.PASS;
                }
            }
        }
        player.swingHand(hand);

        // If the entity is not a sheep or the player is not holding shears, do nothing
        return ActionResult.PASS;
    }

    private static int getRandomNumber(int random, int random2) {
        return Random.createLocal().nextBetween(random, random2);
    }

    private static Item getWoolItemByColor(int colorId) {
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
}
