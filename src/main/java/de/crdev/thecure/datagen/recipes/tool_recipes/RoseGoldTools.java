package de.crdev.thecure.datagen.recipes.tool_recipes;

import de.crdev.thecure.block.ModBlocks;
import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class RoseGoldTools {
    public static void generateShapelessRecipes(RecipeExporter exporter) {
    }

    public static void generateShapedRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSE_GOLD_SWORD, 1)
                .pattern(" i ")
                .pattern(" i ")
                .pattern(" s ")

                .input('s', Items.STICK)
                .input('i', ModItems.ROSE_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROSE_GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ROSE_GOLD_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSE_GOLD_PICKAXE, 1)
                .pattern("iii")
                .pattern(" s ")
                .pattern(" s ")

                .input('s', Items.STICK)
                .input('i', ModItems.ROSE_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROSE_GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ROSE_GOLD_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSE_GOLD_SHOVEL, 1)
                .pattern(" i ")
                .pattern(" s ")
                .pattern(" s ")

                .input('s', Items.STICK)
                .input('i', ModItems.ROSE_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROSE_GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ROSE_GOLD_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSE_GOLD_AXE, 1)
                .pattern(" ii")
                .pattern(" si")
                .pattern(" s ")

                .input('s', Items.STICK)
                .input('i', ModItems.ROSE_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROSE_GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ROSE_GOLD_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSE_GOLD_HOE, 1)
                .pattern(" ii")
                .pattern(" s ")
                .pattern(" s ")

                .input('s', Items.STICK)
                .input('i', ModItems.ROSE_GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROSE_GOLD_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ROSE_GOLD_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                        FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
}
