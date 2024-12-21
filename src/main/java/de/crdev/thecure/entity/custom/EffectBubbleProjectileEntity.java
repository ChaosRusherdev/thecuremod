package de.crdev.thecure.entity.custom;

import de.crdev.thecure.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EffectBubbleProjectileEntity extends ThrownItemEntity {
    public EffectBubbleProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public EffectBubbleProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.THROWN_EFFECT_BUBBLE_PROJECTILE,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
