package its.sheepish.fragments.action;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.items.ModItems;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;

public class SpawnerSilkTouchHandler {
    public static void registerEventHandler() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (!world.isClient && state.getBlock() instanceof net.minecraft.block.SpawnerBlock) {
                System.out.println("Detected a spawner block at: " + pos);
                blockEntity = world.getBlockEntity(pos);
                MobSpawnerBlockEntity spawner = (MobSpawnerBlockEntity) blockEntity;
                ItemStack tool = player.getStackInHand(player.getActiveHand());
                boolean hasSilk = EnchantmentHelper.hasSilkTouch(tool);
                if (hasSilk) {
                    System.out.println("Player has Silk Touch on the tool");
                    ItemStack spawnerFragment = new ItemStack(ModItems.SpawnerFragment);
                    world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), spawnerFragment));
                    System.out.println("Dropped SpawnerFragment at: " + pos);
                }
            }
        });
        Fragments.LOGGER.info("Added spawner functionality for "+Fragments.MOD_ID);
    }
}