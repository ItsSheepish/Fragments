package its.sheepish.fragments.recipe;

import its.sheepish.fragments.Fragments;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void regiserRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Fragments.MOD_ID, SoulInfuserRecipe.Serializer.ID),
                SoulInfuserRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Fragments.MOD_ID, SoulInfuserRecipe.Type.ID),
                SoulInfuserRecipe.Type.INSTANCE);
    }
}
