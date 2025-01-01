package de.crdev.thecure.item.custom;

import de.crdev.thecure.particle.ModParticles;
import de.crdev.thecure.particle.utils.ParticleUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TestItem extends Item {

    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ParticleUtils.spawnParticleSphere(world, player.getBlockPos(), 10f, 1600, ModParticles.CUSTOMIZABLE_PARTICLE);

        return super.use(world, player, hand);
    } //

}
