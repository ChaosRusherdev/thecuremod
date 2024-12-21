package de.crdev.thecure.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class SculcAcid extends StatusEffect {
    protected SculcAcid(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) {
            return; // Ensure this only happens server-side
        }

        if(entity instanceof PlayerEntity player) {
            if(!entity.isAlive() || player.isCreative()) {
                return;
            }
        }
        entity.setHealth(entity.getHealth() - 1);

        entity.getWorld().playSound(
                null, // null will make the sound audible to all players
                entity.getBlockPos(), // Position of the entity
                SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT,
                SoundCategory.PLAYERS,
                0.8F, // Volume (1.0 is normal volume)
                2.0F // Pitch (1.0 is the default pitch)
        );

        super.applyUpdateEffect(entity, amplifier);
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // interval = ticks 20 ticks = 1 sec
        int interval = 16; // Number of ticks to wait between effects
        return duration % interval == 0;
    }
}
