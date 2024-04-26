package its.sheepish.fragments.items;


import its.sheepish.fragments.Fragments;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {
    public static final ItemGroup FragmentGroup = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Fragments.MOD_ID, "fragments"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fragmentation"))
                    .icon(() -> new ItemStack(ModItems.SpawnerFragment)).entries((displayContext, entries) -> {

                        entries.add(ModItems.DiamondFragment);
                        entries.add(ModItems.DiamondCut);
                        entries.add(ModItems.SpawnerFragment);

                    }).build());

    public static void registerModGroups() {
        Fragments.LOGGER.info("Making some fantastic item groups for "+Fragments.MOD_ID);
    }
}
