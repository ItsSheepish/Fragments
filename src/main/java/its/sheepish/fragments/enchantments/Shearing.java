package its.sheepish.fragments.enchantments;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.items.custom.DiamondShearsItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;

public class Shearing extends Enchantment {
    public Shearing() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{});
        Fragments.LOGGER.info("Registering the shearing enchantment for "+Fragments.MOD_ID);
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof DiamondShearsItem || stack.getItem() instanceof ShearsItem;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }
}