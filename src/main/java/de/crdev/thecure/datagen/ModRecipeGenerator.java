package de.crdev.thecure.datagen;

import de.crdev.thecure.datagen.recipes.ore_recipes.OreRecipes;
import de.crdev.thecure.datagen.recipes.potion_recipes.JarRecipes;
import de.crdev.thecure.datagen.recipes.potion_recipes.VialRecipes;
import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        OreRecipes.generateShapedOreRecipes(exporter);
        OreRecipes.generateShapelessOreRecipes(exporter);

        JarRecipes.generateShapedJarRecipes(exporter);
        JarRecipes.generateShapelessJarRecipes(exporter);

        VialRecipes.generateShapedVialRecipes(exporter);
        VialRecipes.generateShapelessVialRecipes(exporter);

        offerSmelting(exporter, List.of(ModItems.COPPER_GOLD_ALLOY), RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT,
                0.25f, 200, "the_cure");

        offerBlasting(exporter, List.of(ModItems.COPPER_GOLD_ALLOY), RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT,
                0.25f, 100, "the_cure");

    }
}
