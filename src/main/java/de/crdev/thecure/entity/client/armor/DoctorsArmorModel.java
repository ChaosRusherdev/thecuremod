package de.crdev.thecure.entity.client.armor;

import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.item.custom.armor.DoctorsArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DoctorsArmorModel extends AnimatedGeoModel<DoctorsArmorItem> {
    @Override
    public Identifier getModelResource(DoctorsArmorItem object) {
        return new Identifier(TheCureMod.MOD_ID, "geo/doctors_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(DoctorsArmorItem object) {
        return new Identifier(TheCureMod.MOD_ID, "textures/models/armor/doctors_armor.png");
    }

    @Override
    public Identifier getAnimationResource(DoctorsArmorItem animatable) {
        return new Identifier(TheCureMod.MOD_ID, "animations/doctors_armor.animation.json");
    }
}
