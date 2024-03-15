package de.crdev.thecure.datagen.recipes.potion_recipes;

import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class JarRecipes {
    public static void generateShapelessRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SCULC_ACID_JAR, 2)
                .input(ModItems.GLASS_JAR)
                .input(Items.BLAZE_POWDER)
                .input(Items.SCULK)
                .criterion(FabricRecipeProvider.hasItem(Items.SCULK),
                        FabricRecipeProvider.conditionsFromItem(Items.SCULK))
                .offerTo(exporter);
    }

    public static void generateShapedRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GLASS_JAR, 1)
                .pattern(" b ")
                .pattern("g g")
                .pattern("ggg")

                .input('b', Items.OAK_BUTTON)
                .input('g', Items.GLASS)
                .criterion(FabricRecipeProvider.hasItem(Items.GLASS),
                        FabricRecipeProvider.conditionsFromItem(Items.GLASS))
                .offerTo(exporter);
    }
}
