package its.sheepish.fragments.enchantments;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.items.custom.ScytheItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class SoulReaper extends Enchantment {
    public SoulReaper() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{});
        Fragments.LOGGER.info("Registering the soul reaper enchantment for "+Fragments.MOD_ID);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ScytheItem
                || stack.getItem() instanceof SwordItem
                || stack.getItem() instanceof PickaxeItem
                || stack.getItem() instanceof AxeItem
                || stack.getItem() instanceof ShovelItem
                || stack.getItem() instanceof HoeItem;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
}
