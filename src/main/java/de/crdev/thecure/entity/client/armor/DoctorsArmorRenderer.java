package de.crdev.thecure.entity.client.armor;

import de.crdev.thecure.item.custom.DoctorsArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class DoctorsArmorRenderer extends GeoArmorRenderer<DoctorsArmorItem> {
    public DoctorsArmorRenderer() {
        super(new DoctorsArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
