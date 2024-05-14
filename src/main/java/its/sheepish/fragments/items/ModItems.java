package its.sheepish.fragments.items;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.items.custom.DiamondShearsItem;
import its.sheepish.fragments.items.custom.DiamondUpgrade;
import its.sheepish.fragments.items.custom.ScytheItem;
import its.sheepish.fragments.items.custom.SoulItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item Sheepish = registerItem("sheepish", new Item(new FabricItemSettings()));

    public static final Item DiamondFragment = registerItem("diamond_frag", new Item(new FabricItemSettings()));
    public static final Item DiamondStick = registerItem("dia_stick", new Item(new FabricItemSettings()));
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

    public static final Item CutDiamondSword = registerItem("diamond_blade",
            new SwordItem(ModToolMaterials.CUT_DIA, 4, -2.6f, new FabricItemSettings()));
    public static final Item CutDiamondPickaxe = registerItem("sharpened_diamond_pickaxe",
            new PickaxeItem(ModToolMaterials.CUT_DIA, 1, -3f, new FabricItemSettings()));
    public static final Item CutDiamondAxe = registerItem("diamond_war_axe",
            new AxeItem(ModToolMaterials.CUT_DIA, 5.5f, -2.9f, new FabricItemSettings()));
    public static final Item CutDiamondShovel = registerItem("diamond_excavator",
            new ShovelItem(ModToolMaterials.CUT_DIA, 0.5f, -3.25f, new FabricItemSettings()));
    public static final Item CutDiamondHoe = registerItem("diamond_scythe",
            new ScytheItem(ModToolMaterials.CUT_DIA, 3, 0, 0.1f, new FabricItemSettings()));


    public static final Item allaySoul = registerItem("allay_soul",
            new SoulItem(EntityType.ALLAY, getSpawnEggPrimaryColor(EntityType.ALLAY), getSpawnEggSecondaryColor(EntityType.ALLAY), new FabricItemSettings()));
    public static final Item axolotlSoul = registerItem("axolotl_soul",
            new SoulItem(EntityType.AXOLOTL, getSpawnEggPrimaryColor(EntityType.AXOLOTL), getSpawnEggSecondaryColor(EntityType.AXOLOTL), new FabricItemSettings()));
    public static final Item batSoul = registerItem("bat_soul",
            new SoulItem(EntityType.BAT, getSpawnEggPrimaryColor(EntityType.BAT), getSpawnEggSecondaryColor(EntityType.BAT), new FabricItemSettings()));
    public static final Item camelSoul = registerItem("camel_soul",
            new SoulItem(EntityType.CAMEL, getSpawnEggPrimaryColor(EntityType.CAMEL), getSpawnEggSecondaryColor(EntityType.CAMEL), new FabricItemSettings()));
    public static final Item catSoul = registerItem("cat_soul",
            new SoulItem(EntityType.CAT, getSpawnEggPrimaryColor(EntityType.CAT), getSpawnEggSecondaryColor(EntityType.CAT), new FabricItemSettings()));
    public static final Item chickenSoul = registerItem("chicken_soul",
            new SoulItem(EntityType.CHICKEN, getSpawnEggPrimaryColor(EntityType.CHICKEN), getSpawnEggSecondaryColor(EntityType.CHICKEN), new FabricItemSettings()));
    public static final Item codSoul = registerItem("cod_soul",
            new SoulItem(EntityType.COD, getSpawnEggPrimaryColor(EntityType.COD), getSpawnEggSecondaryColor(EntityType.COD), new FabricItemSettings()));
    public static final Item cowSoul = registerItem("cow_soul",
            new SoulItem(EntityType.COW, getSpawnEggPrimaryColor(EntityType.COW), getSpawnEggSecondaryColor(EntityType.COW), new FabricItemSettings()));
    public static final Item donkeySoul = registerItem("donkey_soul",
            new SoulItem(EntityType.DONKEY, getSpawnEggPrimaryColor(EntityType.DONKEY), getSpawnEggSecondaryColor(EntityType.DONKEY), new FabricItemSettings()));
    public static final Item frogSoul = registerItem("frog_soul",
            new SoulItem(EntityType.FROG, getSpawnEggPrimaryColor(EntityType.FROG), getSpawnEggSecondaryColor(EntityType.FROG), new FabricItemSettings()));
    public static final Item glow_squidSoul = registerItem("glow_squid_soul",
            new SoulItem(EntityType.GLOW_SQUID, getSpawnEggPrimaryColor(EntityType.GLOW_SQUID), getSpawnEggSecondaryColor(EntityType.GLOW_SQUID), new FabricItemSettings()));
    public static final Item horseSoul = registerItem("horse_soul",
            new SoulItem(EntityType.HORSE, getSpawnEggPrimaryColor(EntityType.HORSE), getSpawnEggSecondaryColor(EntityType.HORSE), new FabricItemSettings()));
    public static final Item mooshroomSoul = registerItem("mooshroom_soul",
            new SoulItem(EntityType.MOOSHROOM, getSpawnEggPrimaryColor(EntityType.MOOSHROOM), getSpawnEggSecondaryColor(EntityType.MOOSHROOM), new FabricItemSettings()));
    public static final Item muleSoul = registerItem("mule_soul",
            new SoulItem(EntityType.MULE, getSpawnEggPrimaryColor(EntityType.MULE), getSpawnEggSecondaryColor(EntityType.MULE), new FabricItemSettings()));
    public static final Item ocelotSoul = registerItem("ocelot_soul",
            new SoulItem(EntityType.OCELOT, getSpawnEggPrimaryColor(EntityType.OCELOT), getSpawnEggSecondaryColor(EntityType.OCELOT), new FabricItemSettings()));
    public static final Item parrotSoul = registerItem("parrot_soul",
            new SoulItem(EntityType.PARROT, getSpawnEggPrimaryColor(EntityType.PARROT), getSpawnEggSecondaryColor(EntityType.PARROT), new FabricItemSettings()));
    public static final Item pigSoul = registerItem("pig_soul",
            new SoulItem(EntityType.PIG, getSpawnEggPrimaryColor(EntityType.PIG), getSpawnEggSecondaryColor(EntityType.PIG), new FabricItemSettings()));
    public static final Item pufferfishSoul = registerItem("pufferfish_soul",
            new SoulItem(EntityType.PUFFERFISH, getSpawnEggPrimaryColor(EntityType.PUFFERFISH), getSpawnEggSecondaryColor(EntityType.PUFFERFISH), new FabricItemSettings()));
    public static final Item rabbitSoul = registerItem("rabbit_soul",
            new SoulItem(EntityType.RABBIT, getSpawnEggPrimaryColor(EntityType.RABBIT), getSpawnEggSecondaryColor(EntityType.RABBIT), new FabricItemSettings()));
    public static final Item salmonSoul = registerItem("salmon_soul",
            new SoulItem(EntityType.SALMON, getSpawnEggPrimaryColor(EntityType.SALMON), getSpawnEggSecondaryColor(EntityType.SALMON), new FabricItemSettings()));
    public static final Item sheepSoul = registerItem("sheep_soul",
            new SoulItem(EntityType.SHEEP, getSpawnEggPrimaryColor(EntityType.SHEEP), getSpawnEggSecondaryColor(EntityType.SHEEP), new FabricItemSettings()));
    public static final Item skeleton_horseSoul = registerItem("skeleton_horse_soul",
            new SoulItem(EntityType.SKELETON_HORSE, getSpawnEggPrimaryColor(EntityType.SKELETON_HORSE), getSpawnEggSecondaryColor(EntityType.SKELETON_HORSE), new FabricItemSettings()));
    public static final Item snifferSoul = registerItem("sniffer_soul",
            new SoulItem(EntityType.SNIFFER, getSpawnEggPrimaryColor(EntityType.SNIFFER), getSpawnEggSecondaryColor(EntityType.SNIFFER), new FabricItemSettings()));
    public static final Item snow_golemSoul = registerItem("snow_golem_soul",
            new SoulItem(EntityType.SNOW_GOLEM, getSpawnEggPrimaryColor(EntityType.SNOW_GOLEM), getSpawnEggSecondaryColor(EntityType.SNOW_GOLEM), new FabricItemSettings()));
    public static final Item squidSoul = registerItem("squid_soul",
            new SoulItem(EntityType.SQUID, getSpawnEggPrimaryColor(EntityType.SQUID), getSpawnEggSecondaryColor(EntityType.SQUID), new FabricItemSettings()));
    public static final Item striderSoul = registerItem("strider_soul",
            new SoulItem(EntityType.STRIDER, getSpawnEggPrimaryColor(EntityType.STRIDER), getSpawnEggSecondaryColor(EntityType.STRIDER), new FabricItemSettings()));
    public static final Item tadpoleSoul = registerItem("tadpole_soul",
            new SoulItem(EntityType.TADPOLE, getSpawnEggPrimaryColor(EntityType.TADPOLE), getSpawnEggSecondaryColor(EntityType.TADPOLE), new FabricItemSettings()));
    public static final Item tropical_fishSoul = registerItem("tropical_fish_soul",
            new SoulItem(EntityType.TROPICAL_FISH, getSpawnEggPrimaryColor(EntityType.TROPICAL_FISH), getSpawnEggSecondaryColor(EntityType.TROPICAL_FISH), new FabricItemSettings()));
    public static final Item turtleSoul = registerItem("turtle_soul",
            new SoulItem(EntityType.TURTLE, getSpawnEggPrimaryColor(EntityType.TURTLE), getSpawnEggSecondaryColor(EntityType.TURTLE), new FabricItemSettings()));
    public static final Item villagerSoul = registerItem("villager_soul",
            new SoulItem(EntityType.VILLAGER, getSpawnEggPrimaryColor(EntityType.VILLAGER), getSpawnEggSecondaryColor(EntityType.VILLAGER), new FabricItemSettings()));
    public static final Item wandering_traderSoul = registerItem("wandering_trader_soul",
            new SoulItem(EntityType.WANDERING_TRADER, getSpawnEggPrimaryColor(EntityType.WANDERING_TRADER), getSpawnEggSecondaryColor(EntityType.WANDERING_TRADER), new FabricItemSettings()));
    public static final Item beeSoul = registerItem("bee_soul",
            new SoulItem(EntityType.BEE, getSpawnEggPrimaryColor(EntityType.BEE), getSpawnEggSecondaryColor(EntityType.BEE), new FabricItemSettings()));
    public static final Item cave_spiderSoul = registerItem("cave_spider_soul",
            new SoulItem(EntityType.CAVE_SPIDER, getSpawnEggPrimaryColor(EntityType.CAVE_SPIDER), getSpawnEggSecondaryColor(EntityType.CAVE_SPIDER), new FabricItemSettings()));
    public static final Item dolphinSoul = registerItem("dolphin_soul",
            new SoulItem(EntityType.DOLPHIN, getSpawnEggPrimaryColor(EntityType.DOLPHIN), getSpawnEggSecondaryColor(EntityType.DOLPHIN), new FabricItemSettings()));
    public static final Item drownedSoul = registerItem("drowned_soul",
            new SoulItem(EntityType.DROWNED, getSpawnEggPrimaryColor(EntityType.DROWNED), getSpawnEggSecondaryColor(EntityType.DROWNED), new FabricItemSettings()));
    public static final Item endermanSoul = registerItem("enderman_soul",
            new SoulItem(EntityType.ENDERMAN, getSpawnEggPrimaryColor(EntityType.ENDERMAN), getSpawnEggSecondaryColor(EntityType.ENDERMAN), new FabricItemSettings()));
    public static final Item foxSoul = registerItem("fox_soul",
            new SoulItem(EntityType.FOX, getSpawnEggPrimaryColor(EntityType.FOX), getSpawnEggSecondaryColor(EntityType.FOX), new FabricItemSettings()));
    public static final Item goatSoul = registerItem("goat_soul",
            new SoulItem(EntityType.GOAT, getSpawnEggPrimaryColor(EntityType.GOAT), getSpawnEggSecondaryColor(EntityType.GOAT), new FabricItemSettings()));
    public static final Item iron_golemSoul = registerItem("iron_golem_soul",
            new SoulItem(EntityType.IRON_GOLEM, getSpawnEggPrimaryColor(EntityType.IRON_GOLEM), getSpawnEggSecondaryColor(EntityType.IRON_GOLEM), new FabricItemSettings()));
    public static final Item llamaSoul = registerItem("llama_soul",
            new SoulItem(EntityType.LLAMA, getSpawnEggPrimaryColor(EntityType.LLAMA), getSpawnEggSecondaryColor(EntityType.LLAMA), new FabricItemSettings()));
    public static final Item pandaSoul = registerItem("panda_soul",
            new SoulItem(EntityType.PANDA, getSpawnEggPrimaryColor(EntityType.PANDA), getSpawnEggSecondaryColor(EntityType.PANDA), new FabricItemSettings()));
    public static final Item piglinSoul = registerItem("piglin_soul",
            new SoulItem(EntityType.PIGLIN, getSpawnEggPrimaryColor(EntityType.PIGLIN), getSpawnEggSecondaryColor(EntityType.PIGLIN), new FabricItemSettings()));
    public static final Item polar_bearSoul = registerItem("polar_bear_soul",
            new SoulItem(EntityType.POLAR_BEAR, getSpawnEggPrimaryColor(EntityType.POLAR_BEAR), getSpawnEggSecondaryColor(EntityType.POLAR_BEAR), new FabricItemSettings()));
    public static final Item spiderSoul = registerItem("spider_soul",
            new SoulItem(EntityType.SPIDER, getSpawnEggPrimaryColor(EntityType.SPIDER), getSpawnEggSecondaryColor(EntityType.SPIDER), new FabricItemSettings()));
    public static final Item trader_llamaSoul = registerItem("trader_llama_soul",
            new SoulItem(EntityType.TRADER_LLAMA, getSpawnEggPrimaryColor(EntityType.TRADER_LLAMA), getSpawnEggSecondaryColor(EntityType.TRADER_LLAMA), new FabricItemSettings()));
    public static final Item wolfSoul = registerItem("wolf_soul",
            new SoulItem(EntityType.WOLF, getSpawnEggPrimaryColor(EntityType.WOLF), getSpawnEggSecondaryColor(EntityType.WOLF), new FabricItemSettings()));
    public static final Item zombified_piglinSoul = registerItem("zombified_piglin_soul",
            new SoulItem(EntityType.ZOMBIFIED_PIGLIN, getSpawnEggPrimaryColor(EntityType.ZOMBIFIED_PIGLIN), getSpawnEggSecondaryColor(EntityType.ZOMBIFIED_PIGLIN), new FabricItemSettings()));
    public static final Item blazeSoul = registerItem("blaze_soul",
            new SoulItem(EntityType.BLAZE, getSpawnEggPrimaryColor(EntityType.BLAZE), getSpawnEggSecondaryColor(EntityType.BLAZE), new FabricItemSettings()));
    public static final Item creeperSoul = registerItem("creeper_soul",
            new SoulItem(EntityType.CREEPER, getSpawnEggPrimaryColor(EntityType.CREEPER), getSpawnEggSecondaryColor(EntityType.CREEPER), new FabricItemSettings()));
    public static final Item elder_guardianSoul = registerItem("elder_guardian_soul",
            new SoulItem(EntityType.ELDER_GUARDIAN, getSpawnEggPrimaryColor(EntityType.ELDER_GUARDIAN), getSpawnEggSecondaryColor(EntityType.ELDER_GUARDIAN), new FabricItemSettings()));
    public static final Item endermiteSoul = registerItem("endermite_soul",
            new SoulItem(EntityType.ENDERMITE, getSpawnEggPrimaryColor(EntityType.ENDERMITE), getSpawnEggSecondaryColor(EntityType.ENDERMITE), new FabricItemSettings()));
    public static final Item evokerSoul = registerItem("evoker_soul",
            new SoulItem(EntityType.EVOKER, getSpawnEggPrimaryColor(EntityType.EVOKER), getSpawnEggSecondaryColor(EntityType.EVOKER), new FabricItemSettings()));
    public static final Item ghastSoul = registerItem("ghast_soul",
            new SoulItem(EntityType.GHAST, getSpawnEggPrimaryColor(EntityType.GHAST), getSpawnEggSecondaryColor(EntityType.GHAST), new FabricItemSettings()));
    public static final Item guardianSoul = registerItem("guardian_soul",
            new SoulItem(EntityType.GUARDIAN, getSpawnEggPrimaryColor(EntityType.GUARDIAN), getSpawnEggSecondaryColor(EntityType.GUARDIAN), new FabricItemSettings()));
    public static final Item hoglinSoul = registerItem("hoglin_soul",
            new SoulItem(EntityType.HOGLIN, getSpawnEggPrimaryColor(EntityType.HOGLIN), getSpawnEggSecondaryColor(EntityType.HOGLIN), new FabricItemSettings()));
    public static final Item huskSoul = registerItem("husk_soul",
            new SoulItem(EntityType.HUSK, getSpawnEggPrimaryColor(EntityType.HUSK), getSpawnEggSecondaryColor(EntityType.HUSK), new FabricItemSettings()));
    public static final Item magma_cubeSoul = registerItem("magma_cube_soul",
            new SoulItem(EntityType.MAGMA_CUBE, getSpawnEggPrimaryColor(EntityType.MAGMA_CUBE), getSpawnEggSecondaryColor(EntityType.MAGMA_CUBE), new FabricItemSettings()));
    public static final Item phantomSoul = registerItem("phantom_soul",
            new SoulItem(EntityType.PHANTOM, getSpawnEggPrimaryColor(EntityType.PHANTOM), getSpawnEggSecondaryColor(EntityType.PHANTOM), new FabricItemSettings()));
    public static final Item piglin_bruteSoul = registerItem("piglin_brute_soul",
            new SoulItem(EntityType.PIGLIN_BRUTE, getSpawnEggPrimaryColor(EntityType.PIGLIN_BRUTE), getSpawnEggSecondaryColor(EntityType.PIGLIN_BRUTE), new FabricItemSettings()));
    public static final Item pillagerSoul = registerItem("pillager_soul",
            new SoulItem(EntityType.PILLAGER, getSpawnEggPrimaryColor(EntityType.PILLAGER), getSpawnEggSecondaryColor(EntityType.PILLAGER), new FabricItemSettings()));
    public static final Item ravagerSoul = registerItem("ravager_soul",
            new SoulItem(EntityType.RAVAGER, getSpawnEggPrimaryColor(EntityType.RAVAGER), getSpawnEggSecondaryColor(EntityType.RAVAGER), new FabricItemSettings()));
    public static final Item shulkerSoul = registerItem("shulker_soul",
            new SoulItem(EntityType.SHULKER, getSpawnEggPrimaryColor(EntityType.SHULKER), getSpawnEggSecondaryColor(EntityType.SHULKER), new FabricItemSettings()));
    public static final Item silverfishSoul = registerItem("silverfish_soul",
            new SoulItem(EntityType.SILVERFISH, getSpawnEggPrimaryColor(EntityType.SILVERFISH), getSpawnEggSecondaryColor(EntityType.SILVERFISH), new FabricItemSettings()));
    public static final Item skeletonSoul = registerItem("skeleton_soul",
            new SoulItem(EntityType.SKELETON, getSpawnEggPrimaryColor(EntityType.SKELETON), getSpawnEggSecondaryColor(EntityType.SKELETON), new FabricItemSettings()));
    public static final Item slimeSoul = registerItem("slime_soul",
            new SoulItem(EntityType.SLIME, getSpawnEggPrimaryColor(EntityType.SLIME), getSpawnEggSecondaryColor(EntityType.SLIME), new FabricItemSettings()));
    public static final Item straySoul = registerItem("stray_soul",
            new SoulItem(EntityType.STRAY, getSpawnEggPrimaryColor(EntityType.STRAY), getSpawnEggSecondaryColor(EntityType.STRAY), new FabricItemSettings()));
    public static final Item vexSoul = registerItem("vex_soul",
            new SoulItem(EntityType.VEX, getSpawnEggPrimaryColor(EntityType.VEX), getSpawnEggSecondaryColor(EntityType.VEX), new FabricItemSettings()));
    public static final Item vindicatorSoul = registerItem("vindicator_soul",
            new SoulItem(EntityType.VINDICATOR, getSpawnEggPrimaryColor(EntityType.VINDICATOR), getSpawnEggSecondaryColor(EntityType.VINDICATOR), new FabricItemSettings()));
    public static final Item wardenSoul = registerItem("warden_soul",
            new SoulItem(EntityType.WARDEN, getSpawnEggPrimaryColor(EntityType.WARDEN), getSpawnEggSecondaryColor(EntityType.WARDEN), new FabricItemSettings()));
    public static final Item witchSoul = registerItem("witch_soul",
            new SoulItem(EntityType.WITCH, getSpawnEggPrimaryColor(EntityType.WITCH), getSpawnEggSecondaryColor(EntityType.WITCH), new FabricItemSettings()));
    public static final Item wither_skeletonSoul = registerItem("wither_skeleton_soul",
            new SoulItem(EntityType.WITHER_SKELETON, getSpawnEggPrimaryColor(EntityType.WITHER_SKELETON), getSpawnEggSecondaryColor(EntityType.WITHER_SKELETON), new FabricItemSettings()));
    public static final Item zoglinSoul = registerItem("zoglin_soul",
            new SoulItem(EntityType.ZOGLIN, getSpawnEggPrimaryColor(EntityType.ZOGLIN), getSpawnEggSecondaryColor(EntityType.ZOGLIN), new FabricItemSettings()));
    public static final Item zombieSoul = registerItem("zombie_soul",
            new SoulItem(EntityType.ZOMBIE, getSpawnEggPrimaryColor(EntityType.ZOMBIE), getSpawnEggSecondaryColor(EntityType.ZOMBIE), new FabricItemSettings()));
    public static final Item zombie_villagerSoul = registerItem("zombie_villager_soul",
            new SoulItem(EntityType.ZOMBIE_VILLAGER, getSpawnEggPrimaryColor(EntityType.ZOMBIE_VILLAGER), getSpawnEggSecondaryColor(EntityType.ZOMBIE_VILLAGER), new FabricItemSettings()));


    private static int getSpawnEggPrimaryColor(EntityType<?> entityType) {
        SpawnEggItem spawnEggItem = SpawnEggItem.forEntity(entityType);
        if (spawnEggItem != null) {
            return spawnEggItem.getColor(0);
        }
        // Default color if spawn egg is not found
        return 0xFFFFFF; // White color
    }

    // Utility method to get the secondary color of the spawn egg associated with the entity type
    private static int getSpawnEggSecondaryColor(EntityType<?> entityType) {
        SpawnEggItem spawnEggItem = SpawnEggItem.forEntity(entityType);
        if (spawnEggItem != null) {
            return spawnEggItem.getColor(1);
        }
        // Default color if spawn egg is not found
        return 0xFFFFFF; // White color
    }


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
