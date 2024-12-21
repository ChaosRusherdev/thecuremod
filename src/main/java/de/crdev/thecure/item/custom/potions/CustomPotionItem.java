package de.crdev.thecure.item.custom.potions;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface CustomPotionItem {

    public void onCraft(ItemStack stack, World world, PlayerEntity player);

    public String getPotionId();
}
