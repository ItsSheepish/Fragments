package its.sheepish.fragments.screen;

import its.sheepish.fragments.Fragments;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<SoulInfuserScreenHandler> SOUL_INFUSER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Fragments.MOD_ID, "soul_infuser"),
                    new ExtendedScreenHandlerType<>(SoulInfuserScreenHandler::new));

    public static void registerScreenHandlers() {
        Fragments.LOGGER.info("Registering Screen Handlers for " + Fragments.MOD_ID);
    }
}
