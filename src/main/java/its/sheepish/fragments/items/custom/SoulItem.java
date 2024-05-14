package its.sheepish.fragments.items.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SoulItem extends SpawnEggItem {
    private final int primaryColor;
    private final int seconaryColor;

    public SoulItem(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
        super(type, primaryColor, secondaryColor, settings);
        this.primaryColor = primaryColor;
        this.seconaryColor = secondaryColor;
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        return ActionResult.SUCCESS;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        return TypedActionResult.fail(itemStack);
    }

    public int getColor(int tintIndex) {
        // Check if the item is an instance of SoulItem
        if (this instanceof SoulItem) {
            // Return primaryColor for all tint indices
            return tintIndex == 0 ? this.primaryColor : this.seconaryColor;
        }
        // If not, use default behavior
        return super.getColor(tintIndex);
    }
}
