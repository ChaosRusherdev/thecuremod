package de.crdev.thecure.item.custom;

import de.crdev.thecure.entity.custom.EffectBubbleProjectileEntity;
import de.crdev.thecure.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtElement;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * Represents a custom item that allows the player to store and consume items.
 * The gauntlet can:
 * - Store items from the player's offhand using Shift + Right-click.
 * - Consume the first stored item using Right-click.
 */
public class PotionGauntletItem extends Item {
    private static final String ITEMS_KEY = "Items"; // NBT key for storing items in the gauntlet.
    private int index = 0;

    /**
     * Constructor for the Potion Gauntlet Item.
     *
     * @param settings Additional item settings.
     */
    public PotionGauntletItem(Settings settings) {
        super(settings);
    }

    /**
     * Called when the player uses the item (right-clicks).
     * Handles different behaviors based on whether the player is sneaking.
     *
     * @param world The game world.
     * @param player The player using the item.
     * @param hand The hand in which the item is held.
     * @return The result of the action, along with the item used.
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand); // The gauntlet item stack.
        NbtCompound nbtCompound = itemStack.getOrCreateNbt(); // Gets or creates the NBT data for the item.

        player.getItemCooldownManager().set(this, 20);

        if (!world.isClient) { // Server-side logic only.
            if (!player.isSneaking()) {
                handleRightClick(world, player, itemStack, nbtCompound);
            } else {
                handleShiftRightClick(player, nbtCompound);
            }
        }

        return TypedActionResult.success(itemStack, world.isClient);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.sendMessage(Text.literal("No items to consume!")); // Inform the player if no items are stored.
        return super.postHit(stack, target, attacker);
    }

    /**
     * Handles the regular right-click action.
     * Consumes the first stored item in the gauntlet's NBT and informs the player.
     *
     * @param world The game world.
     * @param player The player using the item.
     * @param itemStack The gauntlet item stack.
     * @param nbtCompound The NBT compound of the gauntlet.
     */
    private void handleRightClick(World world, PlayerEntity player, ItemStack itemStack, NbtCompound nbtCompound) {
        NbtList itemsList = nbtCompound.getList(ITEMS_KEY, NbtElement.COMPOUND_TYPE);

        if (itemsList.isEmpty()) {
            player.sendMessage(Text.literal("No items to consume!"), true);
            return;
        }

        // Determine the item to consume based on the index
        int consumeIndex = Math.min(index, itemsList.size() - 1); // Safeguard against out-of-bounds
        NbtCompound itemCompound = itemsList.getCompound(consumeIndex);
        ItemStack consumedItem = ItemStack.fromNbt(itemCompound);

        // Notify the player and trigger the effect
        player.sendMessage(Text.literal("Consumed: " + consumedItem.getName().getString()), true);
        ThrowEffectBubble(world, player);

        // Remove the consumed item and update the NBT
        itemsList.remove(consumeIndex);
        nbtCompound.put(ITEMS_KEY, itemsList);
    }

    private void ThrowEffectBubble(World world, PlayerEntity player) {
        world.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            EffectBubbleProjectileEntity effectBubbleProjectileEntity = new EffectBubbleProjectileEntity(player, world);
            effectBubbleProjectileEntity.setItem(ModItems.EFFECT_BUBBLE.getDefaultStack());
            effectBubbleProjectileEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(effectBubbleProjectileEntity);
        }
    }

    /**
     * Handles the Shift + Right-click action.
     * Stores the item from the player's offhand into the gauntlet's NBT.
     *
     * @param player The player using the item.
     * @param nbtCompound The NBT compound of the gauntlet.
     */
    private void handleShiftRightClick(PlayerEntity player, NbtCompound nbtCompound) {
        NbtList itemsList = nbtCompound.getList(ITEMS_KEY, NbtElement.COMPOUND_TYPE);
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
        addItemToNbt(nbtCompound, offHandStack);
        if (!player.isCreative()) {
            offHandStack.decrement(1);
        }
        player.sendMessage(Text.literal("Item stored in gauntlet!"), true);
    }

    /**
     * Adds an item stack to the gauntlet's NBT-stored inventory.
     *
     * @param nbtCompound The NBT compound of the gauntlet.
     * @param item The item stack to store.
     */
    private void addItemToNbt(NbtCompound nbtCompound, ItemStack item) {
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
