package de.crdev.thecure.item.custom.potiongauntlet;

import de.crdev.thecure.entity.custom.EffectBubbleProjectileEntity;
import de.crdev.thecure.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class GauntletProjectileManager {
    void ThrowEffectBubble(World world, PlayerEntity player) {
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            EffectBubbleProjectileEntity effectBubbleProjectileEntity = new EffectBubbleProjectileEntity(player, world);
            effectBubbleProjectileEntity.setItem(ModItems.EFFECT_BUBBLE.getDefaultStack());
            effectBubbleProjectileEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(effectBubbleProjectileEntity);
        }
    }
}
