package its.sheepish.fragments.enchantments;

import its.sheepish.fragments.Fragments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final Enchantment SHEARING = Registry.register(
            Registries.ENCHANTMENT,
            new Identifier(Fragments.MOD_ID, "shearing"),
            new Shearing()
    );
    public static final Enchantment SOUL_REAPER = Registry.register(
            Registries.ENCHANTMENT,
            new Identifier(Fragments.MOD_ID, "soul_reaper"),
            new SoulReaper()
    );

    public static void registerEnchantments() {
        Fragments.LOGGER.info("Registered a couple brilliant enchantments for "+Fragments.MOD_ID);
    }
}
