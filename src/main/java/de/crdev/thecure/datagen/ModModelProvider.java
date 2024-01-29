package de.crdev.thecure.datagen;

import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DOCTORS_GLASSES, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_GOLD_ALLOY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.GLASS_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULC_ACID_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLASS_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULC_ACID_VIAL, Models.GENERATED);
    }
}
