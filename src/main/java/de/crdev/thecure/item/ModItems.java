package de.crdev.thecure.item;

import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.item.custom.SculcAcidJarItem;
import de.crdev.thecure.item.custom.SculcAcidVialItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Armor

//    public static final Item DOCTORS_GLASSES = registerItem("doctors_glasses",
//            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
//    public static final Item DOCTORS_COAT = registerItem("doctors_coat",
//            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
//    public static final Item DOCTORS_BELT = registerItem("doctors_belt",
//            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));

    // Ingots

    public static final Item COPPER_GOLD_ALLOY = registerItem("copper_gold_alloy",
            new Item(new Item.Settings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new Item.Settings()));
    public static final Item ROSE_NETHERITE_INGOT = registerItem("rose_netherite_ingot",
            new Item(new Item.Settings()));

    // Vials

    public static final Item GLASS_JAR = registerItem("glass_jar",
            new Item(new Item.Settings()));
    public static final Item SCULC_ACID_JAR = registerItem("sculc_acid_jar",
            new SculcAcidJarItem(new Item.Settings().maxCount(16)));

    public static final Item GLASS_VIAL = registerItem("glass_vial",
            new Item(new Item.Settings()));
    public static final Item SCULC_ACID_VIAL = registerItem("sculc_acid_vial",
            new SculcAcidVialItem(new Item.Settings().maxCount(16)));

    // Misc

    public static final Item POTION_GAUNTLET = registerItem("potion_gauntlet",
            new SwordItem(ModToolMaterials.ROSE_NETHERITE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                            ModToolMaterials.ROSE_GOLD, 4, -2.5f))));
    // Tools

    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword",
            new SwordItem(ModToolMaterials.ROSE_GOLD,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                    ModToolMaterials.ROSE_GOLD, 3, -2.2f))));

    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new PickaxeItem(ModToolMaterials.ROSE_GOLD,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(
                            ModToolMaterials.ROSE_GOLD, 1, -2.6f))));

    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel",
            new ShovelItem(ModToolMaterials.ROSE_GOLD,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(
                            ModToolMaterials.ROSE_GOLD, 1.5f, -2.8f))));

    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe",
            new AxeItem(ModToolMaterials.ROSE_GOLD,
                    new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(
                            ModToolMaterials.ROSE_GOLD, 6.0f, -2.9f))));

    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe",
            new HoeItem(ModToolMaterials.ROSE_GOLD,
                    new Item.Settings().attributeModifiers(
                            HoeItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD, -2, 0.2f))));

    private static Item registerItem(String name, Item item) {
        Identifier itemID = Identifier.of(TheCureMod.MOD_ID, name);

        return Registry.register(Registries.ITEM, itemID, item);
    }
    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
    }

    public static void registerModItems() {
        TheCureMod.LOGGER.info("Registering Mod Items for " + TheCureMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
