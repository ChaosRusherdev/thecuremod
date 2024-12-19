package de.crdev.thecure.effect;

import de.crdev.thecure.TheCureMod;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;

import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final StatusEffect SCULC_ACID = registerStatusEffect("sculc_acid",
            new SculcAcid(StatusEffectCategory.HARMFUL, 0x00D2FF));

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(TheCureMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        TheCureMod.LOGGER.info("Registering Mod Effects for " + TheCureMod.MOD_ID);
    }
}
