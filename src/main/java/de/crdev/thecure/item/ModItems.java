package de.crdev.thecure.item;

import de.crdev.thecure.TheCureMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PotionItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DOCTORS_GLASSES = registerItem("doctors_glasses",
            new Item(new FabricItemSettings()));

    public static final Item COPPER_GOLD_ALLOY = registerItem("copper_gold_alloy",
            new Item(new FabricItemSettings()));

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot",
            new Item(new FabricItemSettings()));

    public static final Item GLASS_JAR = registerItem("glass_jar",
            new Item(new FabricItemSettings()));

    public static final Item SCULC_ACID_JAR = registerItem("sculc_acid_jar",
            new Item(new FabricItemSettings()));

    public static final Item GLASS_VIAL = registerItem("glass_vial",
            new Item(new FabricItemSettings()));

    public static final Item SCULC_ACID_VIAL = registerItem("sculc_acid_vial",
            new Item(new FabricItemSettings()));


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
