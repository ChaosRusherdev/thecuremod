package de.crdev.thecure;

import de.crdev.thecure.entity.client.SculcAcidJarProjectileRenderer;
import de.crdev.thecure.entity.client.SculcAcidVialProjectileRenderer;
import de.crdev.thecure.fluid.ModFluids;
import de.crdev.thecure.particle.ModParticles;
import de.crdev.thecure.particle.SculcAcidParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.Identifier;

import static de.crdev.thecure.entity.ModEntities.THROWN_SCULC_ACID_JAR_PROJECTILE;
import static de.crdev.thecure.entity.ModEntities.THROWN_SCULC_ACID_VIAL_PROJECTILE;

public class TheCureModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(THROWN_SCULC_ACID_JAR_PROJECTILE, ctx -> new FlyingItemEntityRenderer<>(ctx));
        EntityRendererRegistry.register(THROWN_SCULC_ACID_VIAL_PROJECTILE, ctx -> new FlyingItemEntityRenderer<>(ctx));

        ParticleFactoryRegistry.getInstance().register(ModParticles.SCULC_ACID_PARTICLE, SculcAcidParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.STILL_SCULC_ACID,
                ModFluids.FLOWING_SCULC_ACID,
                new SimpleFluidRenderHandler(
                        Identifier.of(TheCureMod.MOD_ID, "block/sculc_acid_still"),
                        Identifier.of("minecraft", "block/water_flow"),
                        0xFFFFFFFF
                )
        );

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SCULC_ACID, ModFluids.FLOWING_SCULC_ACID
        );
    }
}