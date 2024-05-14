package its.sheepish.fragments.blocks;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.blocks.custom.SoulInfuserBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SOUL_INFUSER = registerBlock("soul_infuser",
            new SoulInfuserBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Fragments.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Fragments.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Fragments.LOGGER.info("Registering ModBlocks for " + Fragments.MOD_ID);
    }
}
