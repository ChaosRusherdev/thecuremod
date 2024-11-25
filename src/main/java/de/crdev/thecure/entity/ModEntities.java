package de.crdev.thecure.entity;

import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.entity.custom.SculcAcidJarProjectileEntity;
import de.crdev.thecure.entity.custom.SculcAcidVialProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<SculcAcidJarProjectileEntity> THROWN_SCULC_ACID_JAR_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
        new Identifier(TheCureMod.MOD_ID, "sculc_acid_jar_projectile"),
            FabricEntityTypeBuilder.<SculcAcidJarProjectileEntity>create(SpawnGroup.CREATURE, SculcAcidJarProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<SculcAcidVialProjectileEntity> THROWN_SCULC_ACID_VIAL_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
        new Identifier(TheCureMod.MOD_ID, "sculc_acid_vial_projectile"),
            FabricEntityTypeBuilder.<SculcAcidVialProjectileEntity>create(SpawnGroup.CREATURE, SculcAcidVialProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static void registerModEntities() {
        TheCureMod.LOGGER.info("Registering Mod Entities for " + TheCureMod.MOD_ID);
    }
}
