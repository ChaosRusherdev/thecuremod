package de.crdev.thecure.item.custom.potions;

import de.crdev.thecure.entity.custom.SculcAcidJarProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SculcAcidJarItem extends Item implements CustomPotionItem{
    public SculcAcidJarItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.getItemCooldownManager().set(this, 20);

        ItemStack itemStack = player.getStackInHand(hand);
        world.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            SculcAcidJarProjectileEntity sculcAcidProjectileVialEntity = new SculcAcidJarProjectileEntity(player, world);
            sculcAcidProjectileVialEntity.setItem(itemStack);
            sculcAcidProjectileVialEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(sculcAcidProjectileVialEntity);
        }

        player.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!player.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        stack.getOrCreateNbt().putString("Potion", getPotionId());
    }

    @Override
    public String getPotionId() {
        return "thecure:sculc_acid_jar";
    }
}

