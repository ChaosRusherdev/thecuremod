package de.crdev.thecure.entity;

import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.entity.custom.SculcAcidJarProjectileEntity;
import de.crdev.thecure.entity.custom.SculcAcidVialProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<SculcAcidJarProjectileEntity> THROWN_SCULC_ACID_JAR_PROJECTILE =
            Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(TheCureMod.MOD_ID, "sculc_acid_jar"),
                    EntityType.Builder.<SculcAcidJarProjectileEntity>create(SculcAcidJarProjectileEntity::new, SpawnGroup.MISC)
                            .dimensions(0.25f, 0.25f)
                            .build());

    public static final EntityType<SculcAcidVialProjectileEntity> THROWN_SCULC_ACID_VIAL_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TheCureMod.MOD_ID, "sculc_acid_vial_projectile"),
            EntityType.Builder.<SculcAcidVialProjectileEntity>create(SculcAcidVialProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 1f).build());

    public static void registerModEntities() {
        TheCureMod.LOGGER.info("Registering Mod Entities for " + TheCureMod.MOD_ID);
    }
}
