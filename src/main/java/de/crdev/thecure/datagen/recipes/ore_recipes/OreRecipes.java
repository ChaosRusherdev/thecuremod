package de.crdev.thecure.datagen.recipes.ore_recipes;

import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class OreRecipes {
    public static void generateShapelessOreRecipes(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(ModItems.COPPER_GOLD_ALLOY, 3)
                .input(ModItems.SCULC_ACID_JAR)
                .input(Items.RAW_GOLD)
                .input(Items.RAW_COPPER)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SCULC_ACID_JAR),
                        FabricRecipeProvider.conditionsFromItem(ModItems.SCULC_ACID_JAR))
                .offerTo(exporter);
    }

    public static void generateShapedOreRecipes(Consumer<RecipeJsonProvider> exporter) {

    }
}
