package de.crdev.thecure.item.custom.potiongauntlet;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;

public class GauntletNbtManager {
    final String ITEMS_KEY = "Items"; // NBT key for storing items in the gauntlet.
    int index = 0;

    /**
     * Adds an item stack to the gauntlet's NBT-stored inventory.
     *
     * @param nbtCompound The NBT compound of the gauntlet.
     * @param item The item stack to store.
     */
    void addItemToNbt(NbtCompound nbtCompound, ItemStack item) {
        NbtList itemsList = nbtCompound.getList(ITEMS_KEY, NbtElement.COMPOUND_TYPE); // Retrieves or creates the items list.
        NbtCompound newItemCompound = new NbtCompound();
        item.writeNbt(newItemCompound); // Write the item data into the NBT compound.

        itemsList.add(newItemCompound); // Add the new item to the list.
        nbtCompound.put(ITEMS_KEY, itemsList); // Update the NBT with the new list.
    }

    public void ToggleNextSlot() {
        if(index < 9) index++;
        else index = 0;
    }

    public NbtElement GetCurSlot(PlayerEntity player) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        NbtCompound nbtCompound = itemStack.getOrCreateNbt();
        NbtList itemsList = nbtCompound.getList(ITEMS_KEY, NbtElement.COMPOUND_TYPE);

        return itemsList.get(index);
    }
}
