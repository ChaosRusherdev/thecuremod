package de.crdev.thecure.datagen.recipes.decorative_recipes;
import de.crdev.thecure.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

// Used for decorative blocks only, no functional blocks

public class BlockRecipes {
    public static void generateShapelessRecipes(RecipeExporter exporter) {

    }

    public static void generateShapedRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ROSE_GOLD_BRICKS, 4)
                .pattern(" b ")
                .pattern("brb")
                .pattern(" b ")

                .input('b', Blocks.STONE_BRICKS)
                .input('r', ModBlocks.ROSE_GOLD_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.ROSE_GOLD_BLOCK),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.ROSE_GOLD_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(Blocks.STONE_BRICKS),
                        FabricRecipeProvider.conditionsFromItem(Blocks.STONE_BRICKS))
                .offerTo(exporter);
    }
}
