package de.crdev.thecure.item;

import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.item.custom.*;
import de.crdev.thecure.item.custom.potions.SculcAcidJarItem;
import de.crdev.thecure.item.custom.potions.SculcAcidVialItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    // Armor

    public static final Item DOCTORS_GLASSES = registerItem("doctors_glasses",
            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, EquipmentSlot.HEAD, new FabricItemSettings().fireproof()
                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item DOCTORS_COAT = registerItem("doctors_coat",
            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, EquipmentSlot.CHEST, new FabricItemSettings().fireproof()
                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item DOCTORS_BELT = registerItem("doctors_belt",
            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, EquipmentSlot.LEGS, new FabricItemSettings().fireproof()
                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));

    // Ingots

    public static final Item COPPER_GOLD_ALLOY = registerItem("copper_gold_alloy",
            new Item(new FabricItemSettings().group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item ROSE_NETHERITE_INGOT = registerItem("rose_netherite_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.THE_CURE_ITEM_GROUP)));

    // Vials

    public static final Item GLASS_JAR = registerItem("glass_jar",
            new Item(new FabricItemSettings().group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item SCULC_ACID_JAR = registerItem("sculc_acid_jar",
            new SculcAcidJarItem(new FabricItemSettings().maxCount(16).group(ModItemGroup.THE_CURE_ITEM_GROUP)));

    public static final Item GLASS_VIAL = registerItem("glass_vial",
            new Item(new FabricItemSettings().group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item SCULC_ACID_VIAL = registerItem("sculc_acid_vial",
            new SculcAcidVialItem(new FabricItemSettings().maxCount(16).group(ModItemGroup.THE_CURE_ITEM_GROUP)));

    // Tools

    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword",
            new SwordItem(ModToolMaterial.ROSE_GOLD, 4, -2.4f, new FabricItemSettings()
                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new PickaxeItem(ModToolMaterial.ROSE_GOLD, 2, -2.8f, new FabricItemSettings()
                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel",
            new ShovelItem(ModToolMaterial.ROSE_GOLD, 3, -3.0f, new FabricItemSettings()
                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));
    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe",
            new AxeItem(ModToolMaterial.ROSE_GOLD, 6, -3f, new FabricItemSettings()
                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));
//    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe",
//            new HoeItem(ModToolMaterial.ROSE_GOLD, -1, 0f, new FabricItemSettings()
//                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));

    // Special Items / Weapons

    public static final Item POTION_GAUNTLET = registerItem("potion_gauntlet",
            new PotionGauntletItem(
                    ToolMaterials.NETHERITE, 5, -3f, new FabricItemSettings()
                    .group(ModItemGroup.THE_CURE_ITEM_GROUP)));



    // Util items for display purposes only

    public static final Item EFFECT_BUBBLE = registerItem("effect_bubble",
            new Item(new FabricItemSettings()));


    // Helper fuctions

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TheCureMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TheCureMod.LOGGER.info("Registering Mod Items for " + TheCureMod.MOD_ID);

    }
}
