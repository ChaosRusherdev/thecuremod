package de.crdev.thecure.item.client;

import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.item.custom.DoctorsArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DoctorsArmorModel extends GeoModel<DoctorsArmorItem> {

    @Override
    public Identifier getModelResource(DoctorsArmorItem animatable) {
        return new Identifier(TheCureMod.MOD_ID, "geo/doctors_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(DoctorsArmorItem animatable) {
        return new Identifier(TheCureMod.MOD_ID, "textures/armor/doctors_armor.png");
    }

    @Override
    public Identifier getAnimationResource(DoctorsArmorItem animatable) {
        return new Identifier(TheCureMod.MOD_ID, "animations/doctors_armor.animation.json");
    }
}