package its.sheepish.fragments.items;


import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.blocks.ModBlocks;
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
                        entries.add(ModItems.DiamondStick);
                        entries.add(ModItems.DiamondCut);
                        entries.add(ModItems.SpawnerFragment);

                        entries.add(ModItems.DiamondShears);
                        entries.add(ModItems.NetheriteShears);

                        entries.add(ModItems.DiamondUpgrade);

                        entries.add(ModItems.CutDiamondSword);
                        entries.add(ModItems.CutDiamondPickaxe);
                        entries.add(ModItems.CutDiamondAxe);
                        entries.add(ModItems.CutDiamondShovel);
                        entries.add(ModItems.CutDiamondHoe);

                        entries.add(ModBlocks.SOUL_INFUSER);

                    }).build());
    public static final ItemGroup FragmentSoulGroup = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Fragments.MOD_ID, "fragmentsoul"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fragmentedsouls"))
                    .icon(() -> new ItemStack(ModItems.allaySoul)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SOUL_INFUSER);
                        entries.add(ModItems.allaySoul);
                        entries.add(ModItems.axolotlSoul);
                        entries.add(ModItems.batSoul);
                        entries.add(ModItems.camelSoul);
                        entries.add(ModItems.catSoul);
                        entries.add(ModItems.chickenSoul);
                        entries.add(ModItems.codSoul);
                        entries.add(ModItems.cowSoul);
                        entries.add(ModItems.donkeySoul);
                        entries.add(ModItems.frogSoul);
                        entries.add(ModItems.glow_squidSoul);
                        entries.add(ModItems.horseSoul);
                        entries.add(ModItems.mooshroomSoul);
                        entries.add(ModItems.muleSoul);
                        entries.add(ModItems.ocelotSoul);
                        entries.add(ModItems.parrotSoul);
                        entries.add(ModItems.pigSoul);
                        entries.add(ModItems.pufferfishSoul);
                        entries.add(ModItems.rabbitSoul);
                        entries.add(ModItems.salmonSoul);
                        entries.add(ModItems.sheepSoul);
                        entries.add(ModItems.skeleton_horseSoul);
                        entries.add(ModItems.snifferSoul);
                        entries.add(ModItems.snow_golemSoul);
                        entries.add(ModItems.squidSoul);
                        entries.add(ModItems.striderSoul);
                        entries.add(ModItems.tadpoleSoul);
                        entries.add(ModItems.tropical_fishSoul);
                        entries.add(ModItems.turtleSoul);
                        entries.add(ModItems.villagerSoul);
                        entries.add(ModItems.wandering_traderSoul);
                        entries.add(ModItems.beeSoul);
                        entries.add(ModItems.cave_spiderSoul);
                        entries.add(ModItems.dolphinSoul);
                        entries.add(ModItems.drownedSoul);
                        entries.add(ModItems.endermanSoul);
                        entries.add(ModItems.foxSoul);
                        entries.add(ModItems.goatSoul);
                        entries.add(ModItems.iron_golemSoul);
                        entries.add(ModItems.llamaSoul);
                        entries.add(ModItems.pandaSoul);
                        entries.add(ModItems.piglinSoul);
                        entries.add(ModItems.polar_bearSoul);
                        entries.add(ModItems.spiderSoul);
                        entries.add(ModItems.trader_llamaSoul);
                        entries.add(ModItems.wolfSoul);
                        entries.add(ModItems.zombified_piglinSoul);
                        entries.add(ModItems.blazeSoul);
                        entries.add(ModItems.creeperSoul);
                        entries.add(ModItems.elder_guardianSoul);
                        entries.add(ModItems.endermiteSoul);
                        entries.add(ModItems.evokerSoul);
                        entries.add(ModItems.ghastSoul);
                        entries.add(ModItems.guardianSoul);
                        entries.add(ModItems.hoglinSoul);
                        entries.add(ModItems.huskSoul);
                        entries.add(ModItems.magma_cubeSoul);
                        entries.add(ModItems.phantomSoul);
                        entries.add(ModItems.piglin_bruteSoul);
                        entries.add(ModItems.pillagerSoul);
                        entries.add(ModItems.ravagerSoul);
                        entries.add(ModItems.shulkerSoul);
                        entries.add(ModItems.silverfishSoul);
                        entries.add(ModItems.skeletonSoul);
                        entries.add(ModItems.slimeSoul);
                        entries.add(ModItems.straySoul);
                        entries.add(ModItems.vexSoul);
                        entries.add(ModItems.vindicatorSoul);
                        entries.add(ModItems.wardenSoul);
                        entries.add(ModItems.witchSoul);
                        entries.add(ModItems.wither_skeletonSoul);
                        entries.add(ModItems.zoglinSoul);
                        entries.add(ModItems.zombieSoul);
                        entries.add(ModItems.zombie_villagerSoul);

                    }).build());

    public static void registerModGroups() {
        Fragments.LOGGER.info("Made some fantastic item groups for "+Fragments.MOD_ID);
    }
}
