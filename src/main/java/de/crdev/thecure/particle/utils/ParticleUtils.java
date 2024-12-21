package de.crdev.thecure.particle.utils;

import de.crdev.thecure.particle.ModParticles;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ParticleUtils {

    public static void spawnFluidParticleSphere(World world, PlayerEntity player, float radius) {
        double centerX = player.getX();
        double centerY = player.getY() + 1; // Adjust for player height
        double centerZ = player.getZ();

        int particleCount = 100;

        // Gradual appearance and fading of particles
        for (int i = 0; i < particleCount; i++) {
            // Random angle (theta, phi)
            double theta = Math.random() * Math.PI; // Latitude (0 to pi)
            double phi = Math.random() * 2 * Math.PI; // Longitude (0 to 2pi)

            // Calculate x, y, z based on spherical coordinates
            double x = centerX + radius * Math.sin(theta) * Math.cos(phi);
            double y = centerY + radius * Math.cos(theta);
            double z = centerZ + radius * Math.sin(theta) * Math.sin(phi);

            // Calculate random velocity for more fluid movement
            float velocityX = (float) (Math.random() * 0.05 - 0.025); // Small random velocity
            float velocityY = (float) (Math.random() * 0.05 - 0.025);
            float velocityZ = (float) (Math.random() * 0.05 - 0.025);

            // Spawn particle with a gradual fade and longer lifespan
            world.addParticle(ModParticles.SCULC_ACID_PARTICLE,
                    x, y, z,
                    velocityX, velocityY, velocityZ);
        }
    }

    public static void spawnParticleCube(World world, PlayerEntity player, float radius) {
        double centerX = player.getX();
        double centerY = player.getY() + 1; // Adjust for player height
        double centerZ = player.getZ();

        int particleCountPerSide = 10;

        for (int x = 0; x < particleCountPerSide; x++) {
            for (int y = 0; y < particleCountPerSide; y++) {
                for (int z = 0; z < particleCountPerSide; z++) {
                    double offsetX = x * (2 * radius / particleCountPerSide) - radius;
                    double offsetY = y * (2 * radius / particleCountPerSide) - radius;
                    double offsetZ = z * (2 * radius / particleCountPerSide) - radius;

                    // Spawn the particle at the calculated position
                    world.addParticle(ModParticles.SCULC_ACID_PARTICLE,
                            centerX + offsetX,
                            centerY + offsetY,
                            centerZ + offsetZ,
                            0, 0, 0);
                }
            }
        }
    }
}
