package de.crdev.thecure.item;

import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.item.custom.DoctorsArmorItem;
import de.crdev.thecure.item.custom.SculcAcidJarItem;
import de.crdev.thecure.item.custom.SculcAcidVialItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Armor

    public static final Item DOCTORS_GLASSES = registerItem("doctors_glasses",
            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item DOCTORS_COAT = registerItem("doctors_coat",
            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item DOCTORS_BELT = registerItem("doctors_belt",
            new DoctorsArmorItem(ModArmorMaterials.ROSE_NETHERITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));

    // Ingots

    public static final Item COPPER_GOLD_ALLOY = registerItem("copper_gold_alloy",
            new Item(new FabricItemSettings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new FabricItemSettings()));
    public static final Item ROSE_NETHERITE_INGOT = registerItem("rose_netherite_ingot",
            new Item(new FabricItemSettings()));

    // Vials

    public static final Item GLASS_JAR = registerItem("glass_jar",
            new Item(new FabricItemSettings()));
    public static final Item SCULC_ACID_JAR = registerItem("sculc_acid_jar",
            new SculcAcidJarItem(new FabricItemSettings().maxCount(16)));

    public static final Item GLASS_VIAL = registerItem("glass_vial",
            new Item(new FabricItemSettings()));
    public static final Item SCULC_ACID_VIAL = registerItem("sculc_acid_vial",
            new SculcAcidVialItem(new FabricItemSettings().maxCount(16)));

    // Tools

    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword",
            new SwordItem(ModToolMaterial.ROSE_GOLD, 4, -2.4f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe",
            new PickaxeItem(ModToolMaterial.ROSE_GOLD, 2, -2.8f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel",
            new ShovelItem(ModToolMaterial.ROSE_GOLD, 3, -3.0f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe",
            new AxeItem(ModToolMaterial.ROSE_GOLD, 6, -3f, new FabricItemSettings()));
    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe",
            new HoeItem(ModToolMaterial.ROSE_GOLD, -1, 0f, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TheCureMod.MOD_ID, name), item);
    }
    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
    }

    public static void registerModItems() {
        TheCureMod.LOGGER.info("Registering Mod Items for " + TheCureMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
