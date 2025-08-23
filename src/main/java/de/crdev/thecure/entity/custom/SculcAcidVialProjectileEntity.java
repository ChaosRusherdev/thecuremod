package de.crdev.thecure.entity.custom;

import de.crdev.thecure.effect.ModEffects;
import de.crdev.thecure.entity.ModEntities;
import de.crdev.thecure.item.ModItems;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SculcAcidVialProjectileEntity extends ThrownItemEntity {
    private static final int DIRECT_HIT_DURATION_TICKS = 5 * 20;      // 5s
    private static final int CLOUD_DURATION_TICKS = 60;               // 3s
    private static final int CLOUD_EFFECT_DURATION_TICKS = 5 * 20;    // 5s
    private static final float CLOUD_RADIUS = 1.5f;

    public SculcAcidVialProjectileEntity(EntityType<? extends SculcAcidVialProjectileEntity> type, World world) {
        super(type, world);
    }

    public SculcAcidVialProjectileEntity(World world, LivingEntity owner) {
        super(ModEntities.THROWN_SCULC_ACID_VIAL_PROJECTILE, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SCULC_ACID_VIAL;
    }

    @Override
    protected void onEntityHit(EntityHitResult hit) {
        super.onEntityHit(hit);
        if (!getWorld().isClient() && hit.getEntity() instanceof LivingEntity target) {
            target.addStatusEffect(new StatusEffectInstance(ModEffects.SCULC_ACID, DIRECT_HIT_DURATION_TICKS, 0, false, true, true));
            spawnEffectCloud(target.getBlockPos());
            discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);
        if (!getWorld().isClient()) {
            spawnEffectCloud(result.getBlockPos());
            discard();
        }
    }

    private void spawnEffectCloud(BlockPos pos) {
        World world = getWorld();
        AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(
                world,
                pos.getX() + 0.5,
                pos.getY() + 1,
                pos.getZ() + 0.5
        );
        cloud.setRadius(CLOUD_RADIUS);
        cloud.setDuration(CLOUD_DURATION_TICKS);
        cloud.addEffect(new StatusEffectInstance(ModEffects.SCULC_ACID, CLOUD_EFFECT_DURATION_TICKS, 0));
        if (getOwner() instanceof LivingEntity owner) {
            cloud.setOwner(owner);
        }
        world.spawnEntity(cloud);
    }

    public ItemStack asStack() {
        return new ItemStack(ModItems.SCULC_ACID_VIAL);
    }
}