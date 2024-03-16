package de.crdev.thecure.item.client;

import de.crdev.thecure.item.custom.DoctorsArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DoctorsArmorRenderer extends GeoArmorRenderer<DoctorsArmorItem> {
    public DoctorsArmorRenderer() {
        super(new DoctorsArmorModel());
    }
}
