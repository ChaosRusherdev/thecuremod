package de.crdev.thecure.block;

import de.crdev.thecure.TheCureMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));



    public static final Block ROSE_GOLD_BRICKS = registerBlock("rose_gold_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ROSE_GOLD_BRICK_STAIRS = registerBlock("rose_gold_brick_stairs",
            new StairsBlock(ModBlocks.ROSE_GOLD_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ROSE_GOLD_BRICK_SLAB = registerBlock("rose_gold_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TheCureMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TheCureMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TheCureMod.LOGGER.info("Registering ModBlocks for " + TheCureMod.MOD_ID);
    }
}