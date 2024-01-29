package de.crdev.thecure.datagen.recipes.potion_recipes;

import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class JarRecipes {
    public static void generateShapelessJarRecipes(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SCULC_ACID_JAR, 2)
                .input(ModItems.GLASS_JAR)
                .input(Items.BLAZE_POWDER)
                .input(Items.SCULK)
                .criterion(FabricRecipeProvider.hasItem(Items.SCULK),
                        FabricRecipeProvider.conditionsFromItem(Items.SCULK))
                .offerTo(exporter);
    }

    public static void generateShapedJarRecipes(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.GLASS_JAR, 1)
                .pattern(" B ")
                .pattern("G G")
                .pattern("GGG")
                .input('B', Items.OAK_BUTTON)
                .input('G', Items.GLASS)
                .criterion(FabricRecipeProvider.hasItem(Items.GLASS),
                        FabricRecipeProvider.conditionsFromItem(Items.GLASS))
                .offerTo(exporter);
    }
}
