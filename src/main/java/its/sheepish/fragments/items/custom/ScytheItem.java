package its.sheepish.fragments.items.custom;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.enchantments.ModEnchantments;
import its.sheepish.fragments.items.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;


public class ScytheItem extends HoeItem {
    private float dropChance;

    public ScytheItem(ToolMaterial material, int attackDamage, float attackSpeed, float dropChance, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.dropChance = dropChance;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, (entity) -> {
            entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        int soul_lvl = EnchantmentHelper.getLevel(ModEnchantments.SOUL_REAPER, attacker.getStackInHand(Hand.MAIN_HAND));
        if (soul_lvl >= 1) {
            dropChance = dropChance * 2.5f;
        }
        if (!attacker.getWorld().isClient && target.getHealth() <= 0 && attacker instanceof PlayerEntity && Math.random() < dropChance) {
            EntityType<?> entityType = target.getType();
            String entityTypeName = entityType.toString().replace("entity.minecraft.", "");
            String itemName = entityTypeName + "Soul";
            Item soulItem = null;
            try {
                soulItem = (Item) ModItems.class.getField(itemName).get(null);
                ItemStack soulStack = new ItemStack(soulItem);
                target.dropStack(soulStack);
                Fragments.LOGGER.info("dropping soul for "+entityType);
            } catch (Exception e) {
                e.printStackTrace(); // Handle any potential errors
            }
        }
        return true;
    }
}