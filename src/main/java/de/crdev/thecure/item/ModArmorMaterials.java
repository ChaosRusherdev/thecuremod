package de.crdev.thecure.item;

import de.crdev.thecure.TheCureMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final int ROSE_NETHERITE_DURABILITY_MULTIPLIER = 20;

    public static final RegistryEntry<ArmorMaterial> ROSE_NETHERITE = registerMaterial("rose_netherite",
            Map.of(
                    ArmorItem.Type.HELMET, 6,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 8,
                    ArmorItem.Type.BOOTS, 4
            ),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(ModItems.ROSE_NETHERITE_INGOT),
            2.0F,
            0.1F,
            false);

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints,
                                                                int enchantability, RegistryEntry<SoundEvent> equipSound,
                                                                Supplier<Ingredient> repairIngredientSupplier,
                                                                float toughness, float knockbackResistance,
                                                                boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(TheCureMod.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound,
                repairIngredientSupplier, layers, toughness, knockbackResistance);

        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(TheCureMod.MOD_ID, id), material);

        return RegistryEntry.of(material);
    }

    public static void initialize() {
        TheCureMod.LOGGER.info("Registering Armor Materials for " + TheCureMod.MOD_ID);
        // Nothing else needed here as materials are registered as static fields
    }
}