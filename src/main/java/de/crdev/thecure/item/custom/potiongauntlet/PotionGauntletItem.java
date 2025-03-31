package de.crdev.thecure.item.custom.potiongauntlet;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class PotionGauntletItem extends Item {
    GauntletNbtManager gauntletNbtManager = new GauntletNbtManager();
    GauntletProjectileManager gauntletProjectileManager = new GauntletProjectileManager();
    GauntletManager gauntletManager = new GauntletManager(gauntletNbtManager, gauntletProjectileManager);


    public PotionGauntletItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand); // The gauntlet item stack.
        NbtCompound nbtCompound = itemStack.getOrCreateNbt(); // Gets or creates the NBT data for the item.

        player.getItemCooldownManager().set(this, 20);

        if (!world.isClient) { // Server-side logic only.
            if (!player.isSneaking()) {
                gauntletManager.handleRightClick(world, player, nbtCompound);
            } else {
                gauntletManager.handleShiftRightClick(player, nbtCompound);
            }
        }

        return TypedActionResult.success(itemStack, world.isClient);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.sendMessage(Text.literal("No items to consume!")); // Inform the player if no items are stored.
        return super.postHit(stack, target, attacker);
    }


}
