package its.sheepish.fragments;

import its.sheepish.fragments.action.SpawnerSilkTouchHandler;
import its.sheepish.fragments.blocks.ModBlocks;
import its.sheepish.fragments.blocks.entity.ModBlockEntities;
import its.sheepish.fragments.enchantments.ModEnchantments;
import its.sheepish.fragments.items.ModCreativeTabs;
import its.sheepish.fragments.recipe.ModRecipes;
import its.sheepish.fragments.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import its.sheepish.fragments.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fragments implements ModInitializer {
    public static final String MOD_ID = "fragments";
    public static final Logger LOGGER = LoggerFactory.getLogger(Fragments.MOD_ID);

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        //introduction
        LOGGER.info("Heya! :>");
        LOGGER.info("Initialising Fragments...");

        //registers items and creative tabs
        Fragments.init();

        //finished introduction
        LOGGER.info("Initialised Fragments! Enjoy <3");
    }

    public static void init() {
        ModItems.registerAll();
        ModCreativeTabs.registerModGroups();
        ModEnchantments.registerEnchantments();
        SpawnerSilkTouchHandler.registerEventHandler();
        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        ModRecipes.regiserRecipes();
    }
}
