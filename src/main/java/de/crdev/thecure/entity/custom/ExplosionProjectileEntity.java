package de.crdev.thecure.entity.custom;

import de.crdev.thecure.particle.utils.ParticleUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosionProjectileEntity extends ThrownItemEntity {
    public ExplosionProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    // Atm this is just a purrrrpurrrr
    @Override
    protected void onBlockCollision(BlockState state) {
        //ParticleUtils.spawnParticleSphere(world, getBlockPos(), 5f, 400, ParticleTypes.DRAGON_BREATH);
        if (!state.isAir()) {
            world.breakBlock(getBlockPos(), false);

            world.createExplosion(this, getBlockX(), getBlockY(), getBlockZ(), 10f, Explosion.DestructionType.BREAK);
        }

        super.onBlockCollision(state);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
