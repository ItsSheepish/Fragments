package its.sheepish.fragments.items;

import its.sheepish.fragments.Fragments;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DiamondFragment = registerItem("diamond_frag", new Item(new FabricItemSettings()));
    public static final Item DiamondCut = registerItem("diamond_cut", new Item(new FabricItemSettings()));
    public static final Item SpawnerFragment = registerItem("spawner_frag", new Item(new FabricItemSettings()));
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModItems.DiamondFragment);
        entries.add(ModItems.DiamondCut);
        entries.add(ModItems.SpawnerFragment);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Fragments.MOD_ID, name), item);
    }
    public static void registerAll() {
        Fragments.LOGGER.info("Creating some funky fragmented items for "+Fragments.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
