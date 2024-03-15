package de.crdev.thecure.datagen;

import de.crdev.thecure.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ROSE_GOLD_BLOCK);
        addDrop(ModBlocks.ROSE_GOLD_BRICKS);
        addDrop(ModBlocks.ROSE_GOLD_BRICK_STAIRS);
        addDrop(ModBlocks.ROSE_GOLD_BRICK_SLAB, slabDrops(ModBlocks.ROSE_GOLD_BRICK_SLAB));
    }
}
