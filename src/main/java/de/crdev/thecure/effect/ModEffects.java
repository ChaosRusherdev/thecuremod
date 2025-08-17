package de.crdev.thecure.effect;

import de.crdev.thecure.TheCureMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    // Changed from StatusEffect to RegistryEntry<StatusEffect>
    public static final RegistryEntry<StatusEffect> SCULC_ACID = registerStatusEffect("sculc_acid",
            new SculcAcid(StatusEffectCategory.HARMFUL, 0x00D2FF));

    // Updated to return RegistryEntry<StatusEffect>
    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(TheCureMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        TheCureMod.LOGGER.info("Registering Mod Effects for " + TheCureMod.MOD_ID);
    }
}