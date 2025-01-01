package de.crdev.thecure.entity.custom;

import de.crdev.thecure.entity.ModEntities;
import de.crdev.thecure.particle.ModParticles;
import de.crdev.thecure.particle.utils.ParticleUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class EffectBubbleProjectileEntity extends ThrownItemEntity {
    private boolean createSphere = true;

    public EffectBubbleProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public EffectBubbleProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.THROWN_EFFECT_BUBBLE_PROJECTILE,livingEntity, world);
    }

    @Override
    protected void onBlockCollision(BlockState state) {
        if (!state.isAir()) {
            if(createSphere) ParticleUtils.spawnParticleSphere(world, getBlockPos(), 10f, 400, ModParticles.SCULC_ACID_PARTICLE);
            createSphere = false;
        }

        super.onBlockCollision(state);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
