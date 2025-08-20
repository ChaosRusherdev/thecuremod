package de.crdev.thecure.datagen;

import de.crdev.thecure.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                ModBlocks.ROSE_GOLD_BLOCK,
                ModBlocks.ROSE_GOLD_BRICK_SLAB,
                ModBlocks.ROSE_GOLD_BRICK_STAIRS,
                ModBlocks.ROSE_GOLD_BRICKS
                );

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(
            ModBlocks.ROSE_GOLD_BLOCK
        );

        getOrCreateTagBuilder(BlockTags.SLABS).add(
                ModBlocks.ROSE_GOLD_BRICK_SLAB
        );
        getOrCreateTagBuilder(BlockTags.STAIRS).add(
                ModBlocks.ROSE_GOLD_BRICK_STAIRS
        );
    }
}
