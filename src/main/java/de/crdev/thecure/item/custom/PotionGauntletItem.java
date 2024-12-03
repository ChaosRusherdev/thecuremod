package de.crdev.thecure.item.custom;

import de.crdev.thecure.entity.custom.SculcAcidJarProjectileEntity;
import de.crdev.thecure.item.ModItems;
import de.crdev.thecure.ui.CustomInventoryScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
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
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public PotionGauntletItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if(!user.isSneaking()) {
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            user.getItemCooldownManager().set(this, 20);

            if (!world.isClient) {
                SculcAcidJarProjectileEntity sculcAcidProjectileVialEntity = new SculcAcidJarProjectileEntity(user, world);
                sculcAcidProjectileVialEntity.setItem(ModItems.SCULC_ACID_JAR.getDefaultStack());
                sculcAcidProjectileVialEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                world.spawnEntity(sculcAcidProjectileVialEntity);
            }

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!user.getAbilities().creativeMode) {
                itemStack.setDamage(itemStack.getDamage()+1);
            }
            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            user.getItemCooldownManager().set(this, 20);

            System.out.println("clicked");
            if (!world.isClient) {
                user.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                        (syncId, inventory, player) -> new CustomInventoryScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, user.getBlockPos())),
                        Text.literal("Gauntlet Inventory")
                ));
            }
            return TypedActionResult.success(user.getStackInHand(hand));
        }

        }
    }

