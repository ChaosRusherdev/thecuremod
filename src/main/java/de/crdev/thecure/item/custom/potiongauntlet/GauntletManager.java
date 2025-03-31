package de.crdev.thecure.item.custom.potiongauntlet;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class GauntletManager {
    private final GauntletNbtManager _gauntletNbtManager;
    private final GauntletProjectileManager _gauntletProjectileManager;

    public GauntletManager(GauntletNbtManager gauntletNbtManager, GauntletProjectileManager gauntletProjectileManager) {
        _gauntletNbtManager = gauntletNbtManager;
        _gauntletProjectileManager = gauntletProjectileManager;
    }

    void handleRightClick(World world, PlayerEntity player, NbtCompound nbtCompound) {
        NbtList itemsList = nbtCompound.getList(_gauntletNbtManager.ITEMS_KEY, NbtElement.COMPOUND_TYPE);

        if (itemsList.isEmpty()) {
            player.sendMessage(Text.literal("No items to consume!"), true);
            return;
        }

        // Determine the item to consume based on the index
        int consumeIndex = Math.min(_gauntletNbtManager.index, itemsList.size() - 1); // Safeguard against out-of-bounds
        NbtCompound itemCompound = itemsList.getCompound(consumeIndex);
        ItemStack consumedItem = ItemStack.fromNbt(itemCompound);

        // Notify the player and trigger the effect
        player.sendMessage(Text.literal("Consumed: " + consumedItem.getName().getString()), true);
        _gauntletProjectileManager.ThrowEffectBubble(world, player);

        // Remove the consumed item and update the NBT
        itemsList.remove(consumeIndex);
        nbtCompound.put(_gauntletNbtManager.ITEMS_KEY, itemsList);
    }

    /**
     * Handles the Shift + Right-click action.
     * Stores the item from the player's offhand into the gauntlet's NBT.
     *
     * @param player The player using the item.
     * @param nbtCompound The NBT compound of the gauntlet.
     */
    void handleShiftRightClick(PlayerEntity player, NbtCompound nbtCompound) {
        NbtList itemsList = nbtCompound.getList(_gauntletNbtManager.ITEMS_KEY, NbtElement.COMPOUND_TYPE);
        ItemStack offHandStack = player.getOffHandStack();

        if (offHandStack.isEmpty()) {
            player.sendMessage(Text.literal("Offhand is empty. Nothing to store!"), true);
            return;
        }

        if (!offHandStack.getOrCreateNbt().contains("Potion")) {
            player.sendMessage(Text.literal("You can only store Potions in here!"), true);
            return;
        }

        if (itemsList.size() >= 9) {
            player.sendMessage(Text.literal("The gauntlet is full!"), true);
            return;
        }

        // Store the item and decrement stack if not in creative mode
        _gauntletNbtManager.addItemToNbt(nbtCompound, offHandStack);
        if (!player.isCreative()) {
            offHandStack.decrement(1);
        }
        player.sendMessage(Text.literal("Item stored in gauntlet!"), true);
    }
}
