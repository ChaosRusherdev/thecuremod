package de.crdev.thecure.particle;

import de.crdev.thecure.TheCureMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final SimpleParticleType SCULC_ACID_PARTICLE =
            registerParticle("sculc_acid_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        Identifier particleID = Identifier.of(TheCureMod.MOD_ID, name);
        return Registry.register(Registries.PARTICLE_TYPE, particleID, particleType);
    }

    public static void registerParticles() {
        TheCureMod.LOGGER.info("Registering Particles for " + TheCureMod.MOD_ID);
    }
}