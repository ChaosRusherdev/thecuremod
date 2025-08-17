package de.crdev.thecure.block;

import de.crdev.thecure.TheCureMod;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ROSE_GOLD_BLOCK = registerBlockItem(
            "rose_gold_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER)),
            true);

    public static final Block ROSE_GOLD_BRICKS = registerBlockItem(
            "rose_gold_bricks",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER)),
            true);

    public static final Block ROSE_GOLD_BRICK_STAIRS = registerBlockItem(
            "rose_gold_brick_stairs",
            new StairsBlock(ModBlocks.ROSE_GOLD_BRICKS.getDefaultState(), AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER)),
            true
    );
    public static final Block ROSE_GOLD_BRICK_SLAB = registerBlockItem(
            "rose_gold_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.COPPER)),
            true);


    private static Block registerBlockItem(String name, Block block, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(TheCureMod.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void registerModBlocks() {
        TheCureMod.LOGGER.info("Registering ModBlocks for " + TheCureMod.MOD_ID);
    }
}