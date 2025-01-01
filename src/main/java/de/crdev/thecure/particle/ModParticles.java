package de.crdev.thecure.particle;

import de.crdev.thecure.TheCureMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final DefaultParticleType SCULC_ACID_PARTICLE =
            registerParticle("sculc_acid_particle", FabricParticleTypes.simple());
    public static final DefaultParticleType CUSTOMIZABLE_PARTICLE =
            registerParticle("customizable_particle", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registry.PARTICLE_TYPE, new Identifier(TheCureMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        TheCureMod.LOGGER.info("Registering Particles for " + TheCureMod.MOD_ID);
    }
}
