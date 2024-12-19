package de.crdev.thecure.potion;

import de.crdev.thecure.TheCureMod;
import net.minecraft.potion.Potion;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, new Identifier(TheCureMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        TheCureMod.LOGGER.info("Registering Potions for " + TheCureMod.MOD_ID);
    }
}
