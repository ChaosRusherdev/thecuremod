package de.crdev.thecure.entity.custom;

import de.crdev.thecure.effect.ModEffects;
import de.crdev.thecure.entity.ModEntities;
import de.crdev.thecure.particle.ModParticles;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SculcAcidVialProjectileEntity  extends ThrownItemEntity {
    public SculcAcidVialProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public SculcAcidVialProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.THROWN_SCULC_ACID_VIAL_PROJECTILE,livingEntity, world);
    }

//    @Override
//    public Packet<ClientPlayPacketListener> createSpawnPacket() {
//        return new EntitySpawnS2CPacket(this);
//    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity target) {
            target.addStatusEffect(new StatusEffectInstance(ModEffects.SCULC_ACID, 100, 0));
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        World world = getWorld();
        BlockPos hitPos = blockHitResult.getBlockPos();

        if (!world.isClient) {
            AreaEffectCloudEntity effectCloud = new AreaEffectCloudEntity(world, hitPos.getX() + 0.5, hitPos.getY() + 1, hitPos.getZ() + 0.5);

            // Set the radius of the cloud
            effectCloud.setRadius(1.5f); // 3-block radius
            effectCloud.setDuration(60); // Duration in ticks (200 ticks = 10 seconds)

            effectCloud.addEffect(new StatusEffectInstance(ModEffects.SCULC_ACID, 100, 0)); // 5 seconds of Slowness II
            effectCloud.setParticleType(ModParticles.SCULC_ACID_PARTICLE);

            // Add the cloud to the world
            world.spawnEntity(effectCloud);
        }
    }

}

