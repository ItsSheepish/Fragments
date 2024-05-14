package its.sheepish.fragments;

import its.sheepish.fragments.blocks.entity.ModBlockEntities;
import its.sheepish.fragments.blocks.entity.renderer.SoulInfuserBlockEntityRenderer;
import its.sheepish.fragments.screen.ModScreenHandlers;
import its.sheepish.fragments.screen.SoulInfuserScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class FragmentsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.SOUL_INFUSER_SCREEN_HANDLER, SoulInfuserScreen::new);
        BlockEntityRendererFactories.register(ModBlockEntities.SOUL_INFUSER_BLOCK_ENTITY, SoulInfuserBlockEntityRenderer::new);
    }
}
