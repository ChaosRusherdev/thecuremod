package de.crdev.thecure.item.custom;

import de.crdev.thecure.entity.custom.SculcAcidJarProjectileEntity;
import de.crdev.thecure.item.ModItemGroup;
import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import software.bernie.example.entity.RocketProjectile;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;


public class PotionGauntletItem extends Item implements IAnimatable, ISyncable  {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public String controllerName = "controller";
    public static final int ANIM_OPEN = 0;

    public PotionGauntletItem() {
        super(new Item.Settings().maxCount(1).maxDamage(4000).group(ModItemGroup.THE_CURE_ITEM_GROUP));
        GeckoLibNetwork.registerSyncable(this);
    }

    @Override
    public void usageTick(World worldIn, LivingEntity entityLiving, ItemStack stack, int count) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;

            if (stack.getDamage() < (stack.getMaxDamage() - 1)) {
                int cooldown = getCooldown(stack);
                if (cooldown <= 0) {
                    // Perform action
                    if (!worldIn.isClient()) {
                        SculcAcidJarProjectileEntity projectile = new SculcAcidJarProjectileEntity(player, worldIn);
                        projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);
                        worldIn.spawnEntity(projectile);
                    }

                    // Start animation
                    if (!worldIn.isClient()) {
                        final int id = GeckoLibUtil.guaranteeIDForStack(stack, (ServerWorld) worldIn);
                        GeckoLibNetwork.syncAnimation(player, this, id, ANIM_OPEN);
                        for (PlayerEntity otherPlayer : PlayerLookup.tracking(player)) {
                            GeckoLibNetwork.syncAnimation(otherPlayer, this, id, ANIM_OPEN);
                        }
                    }

                    setCooldown(stack, 20); // cooldown value: 100 ticks
                } else {
                    setCooldown(stack, cooldown - 1);
                }
            }
        }
    }
    private int getCooldown(ItemStack stack) {
        if (stack.getNbt() != null && stack.getNbt().contains("Cooldown")) {
            return stack.getNbt().getInt("Cooldown");
        }
        return 0;
    }

    private void setCooldown(ItemStack stack, int cooldown) {
        stack.getOrCreateNbt().putInt("Cooldown", cooldown);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, controllerName, 1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void onAnimationSync(int id, int state) {
        if (state == ANIM_OPEN) {
            final AnimationController<?> controller = GeckoLibUtil.getControllerForID(this.factory, id, controllerName);
            if (controller.getAnimationState() == AnimationState.Stopped) {
                controller.markNeedsReload();
                controller.setAnimation(new AnimationBuilder().addAnimation("firing", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(
                        "Ammo: " + (stack.getMaxDamage() - stack.getDamage() - 1) + " / " + (stack.getMaxDamage() - 1))
                .formatted(Formatting.ITALIC));
    }
}

