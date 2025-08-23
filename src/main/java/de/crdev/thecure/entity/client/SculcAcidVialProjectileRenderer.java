package de.crdev.thecure.entity.client;

import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.entity.custom.SculcAcidVialProjectileEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class SculcAcidVialProjectileRenderer extends EntityRenderer<SculcAcidVialProjectileEntity> {
    public static final Identifier TEXTURE = Identifier.of(TheCureMod.MOD_ID, "textures/entity/sculc_acid/sculc_acid_vial.png");

    public SculcAcidVialProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(SculcAcidVialProjectileEntity entity) {
        return TEXTURE;
    }
}
