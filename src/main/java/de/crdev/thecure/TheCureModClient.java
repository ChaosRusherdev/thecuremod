package de.crdev.thecure;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

import static de.crdev.thecure.entity.ModEntities.THROWN_SCULC_ACID_JAR_PROJECTILE;
import static de.crdev.thecure.entity.ModEntities.THROWN_SCULC_ACID_VIAL_PROJECTILE;

public class TheCureModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(THROWN_SCULC_ACID_JAR_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(THROWN_SCULC_ACID_VIAL_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
