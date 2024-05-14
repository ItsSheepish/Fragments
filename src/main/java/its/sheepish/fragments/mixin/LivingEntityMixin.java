package its.sheepish.fragments.mixin;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.enchantments.ModEnchantments;
import its.sheepish.fragments.items.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDeath(DamageSource source, CallbackInfo ci) {
        if (source.getAttacker() instanceof PlayerEntity) {
            int chance = new Random().nextInt(100);
            int dropChance = 5;
            int soul_lvl = EnchantmentHelper.getLevel(ModEnchantments.SOUL_REAPER, ((PlayerEntity) source.getAttacker()).getStackInHand(Hand.MAIN_HAND));
            if (soul_lvl >= 1) {
                dropChance = dropChance * 4;
            }
            if (chance < dropChance) {
                EntityType<?> entityType = ((Entity) (Object) this).getType();
                String entityTypeName = entityType.toString().replace("entity.minecraft.", "");
                String itemName = entityTypeName + "Soul";
                Item soulItem = null;
                try {
                    soulItem = (Item) ModItems.class.getField(itemName).get(null);
                    Fragments.LOGGER.info("dropping soul for " + entityType);
                } catch (Exception e) {
                    e.printStackTrace(); // Handle any potential errors
                }
                World world = ((Entity) (Object) this).getEntityWorld();
                ItemStack itemStackToDrop = new ItemStack(soulItem);
                ItemEntity itemEntity = new ItemEntity(world, ((Entity) (Object) this).getX(),
                        ((Entity) (Object) this).getY(),
                        ((Entity) (Object) this).getZ(),
                        itemStackToDrop);
                world.spawnEntity(itemEntity);
            }
        }
    }
}
