package de.crdev.thecure;

import de.crdev.thecure.entity.client.armor.DoctorsArmorRenderer;
import de.crdev.thecure.item.ModItems;
import de.crdev.thecure.particle.ModParticles;
import de.crdev.thecure.particle.SculcAcidParticle;
import de.crdev.thecure.ui.ScreenHandlers;
import de.crdev.thecure.ui.client.CustomInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import static de.crdev.thecure.entity.ModEntities.THROWN_SCULC_ACID_JAR_PROJECTILE;
import static de.crdev.thecure.entity.ModEntities.THROWN_SCULC_ACID_VIAL_PROJECTILE;

public class TheCureModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(THROWN_SCULC_ACID_JAR_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(THROWN_SCULC_ACID_VIAL_PROJECTILE, FlyingItemEntityRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.SCULC_ACID_PARTICLE, SculcAcidParticle.Factory::new);

        GeoArmorRenderer.registerArmorRenderer(new DoctorsArmorRenderer(), ModItems.DOCTORS_GLASSES,
                ModItems.DOCTORS_COAT, ModItems.DOCTORS_BELT);
        ScreenRegistry.register(ScreenHandlers.CUSTOM_INVENTORY_SCREEN_HANDLER, CustomInventoryScreen::new);
    }

}
