package de.crdev.thecure.item.custom;

import de.crdev.thecure.entity.custom.SculcAcidJarProjectileEntity;
import de.crdev.thecure.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class PotionGauntletItem extends SwordItem {
    private final DefaultedList<ItemStack> inventory;
    public static final String ITEMS_KEY = "Items";

    public PotionGauntletItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        NbtCompound nbtCompound = itemStack.getOrCreateNbt();

        if (!world.isClient) {
            if (!player.isSneaking()) {
                // Check if the item can store items and is not full
                if (!itemStack.isEmpty() && itemStack.getItem().canBeNested()) {
                    if (!nbtCompound.contains(ITEMS_KEY)) {
                        nbtCompound.put(ITEMS_KEY, new NbtList());
                    }

                    // Example: Adding a new ItemStack as NBT data
                    NbtList itemsList = nbtCompound.getList(ITEMS_KEY, 10); // 10 = NBT compound type
                    ItemStack newItem = new ItemStack(ModItems.SCULC_ACID_JAR); // Example item
                    NbtCompound newItemCompound = new NbtCompound();
                    newItem.writeNbt(newItemCompound);
                    itemsList.add(newItemCompound);
                    nbtCompound.put(ITEMS_KEY, itemsList);
                }
            } else {
                // Example for adding raw NBT if sneaking
                itemStack.setSubNbt(ITEMS_KEY, NbtString.of("Test Item Added"));
            }
        }

        return TypedActionResult.success(itemStack, world.isClient);
    }


    private void onShiftRightClick(PlayerEntity player, World world) {
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        player.getItemCooldownManager().set(this, 20);

//        player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
//                (syncId, inventory, usr) -> new CustomInventoryScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, usr.getBlockPos())),
//                Text.literal("Gauntlet Inventory")
//        ));
    }

    private void onRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        player.getItemCooldownManager().set(this, 20);

        SculcAcidJarProjectileEntity sculcAcidProjectileVialEntity = new SculcAcidJarProjectileEntity(player, world);
        sculcAcidProjectileVialEntity.setItem(ModItems.SCULC_ACID_JAR.getDefaultStack());
        sculcAcidProjectileVialEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
        world.spawnEntity(sculcAcidProjectileVialEntity);

        player.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!player.getAbilities().creativeMode) {
            itemStack.setDamage(itemStack.getDamage()+1);
        }
    }


    public void readInventoryNbt(NbtCompound nbt) {
        if (nbt.contains("Items", 9)) {
            Inventories.readNbt(nbt, this.inventory);
        }

    }

    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, this.inventory, false);
    }
}

