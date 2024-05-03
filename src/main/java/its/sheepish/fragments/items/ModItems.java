package its.sheepish.fragments.items;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.items.custom.DiamondShearsItem;
import its.sheepish.fragments.items.custom.DiamondUpgrade;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DiamondFragment = registerItem("diamond_frag", new Item(new FabricItemSettings()));
    public static final Item DiamondCut = registerItem("diamond_cut", new Item(new FabricItemSettings()));
    public static final Item SpawnerFragment = registerItem("spawner_frag", new Item(new FabricItemSettings()));

    public static final Item DiamondShears = registerItem("diamond_shears", new DiamondShearsItem(new FabricItemSettings().maxCount(1).maxDamage(48), 3, "diamond"));
    public static final Item NetheriteShears = registerItem("netherite_shears", new DiamondShearsItem(new FabricItemSettings().maxCount(1).maxDamage(96), 5, "netherite"));
    public static final Item DiamondUpgrade = registerItem("diamond_upgrade", new DiamondUpgrade(
            Text.of("Shears"),
            Text.of("Diamond"),
            Text.of("Diamond Upgrade"),
            Text.of("For adding diamonds to tools"),
            Text.of("For adding diamonds to shears"),
            null,
            null
    ));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.DiamondFragment);
        entries.add(ModItems.DiamondCut);
        entries.add(ModItems.SpawnerFragment);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Fragments.MOD_ID, name), item);
    }
    public static void registerAll() {
        Fragments.LOGGER.info("Created some funky fragmented items for "+Fragments.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
