package its.sheepish.fragments.blocks.entity;

import its.sheepish.fragments.Fragments;
import its.sheepish.fragments.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<SoulInfuserBlockEntity> SOUL_INFUSER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Fragments.MOD_ID, "soul_infuser_be"),
                    FabricBlockEntityTypeBuilder.create(SoulInfuserBlockEntity::new,ModBlocks.SOUL_INFUSER).build());

    public static void registerBlockEntities() {
        Fragments.LOGGER.info("Registering Block Entities for " + Fragments.MOD_ID);
    }
}
