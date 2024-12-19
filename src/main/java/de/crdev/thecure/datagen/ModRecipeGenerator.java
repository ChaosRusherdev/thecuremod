package de.crdev.thecure.datagen;

import de.crdev.thecure.datagen.recipes.armor_recipes.ArmorRecipes;
import de.crdev.thecure.datagen.recipes.decorative_recipes.BlockRecipes;
import de.crdev.thecure.datagen.recipes.decorative_recipes.SlabRecipes;
import de.crdev.thecure.datagen.recipes.decorative_recipes.StairRecipes;
import de.crdev.thecure.datagen.recipes.ore_recipes.OreRecipes;
import de.crdev.thecure.datagen.recipes.potion_recipes.JarRecipes;
import de.crdev.thecure.datagen.recipes.potion_recipes.VialRecipes;
import de.crdev.thecure.datagen.recipes.tool_recipes.RoseGoldTools;
import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;


import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        OreRecipes.generateShapedOreRecipes(exporter);
        OreRecipes.generateShapelessOreRecipes(exporter);

        JarRecipes.generateShapedRecipes(exporter);
        JarRecipes.generateShapelessRecipes(exporter);

        VialRecipes.generateShapedRecipes(exporter);
        VialRecipes.generateShapelessRecipes(exporter);

        BlockRecipes.generateShapedRecipes(exporter);
        BlockRecipes.generateShapelessRecipes(exporter);

        SlabRecipes.generateShapedRecipes(exporter);
        SlabRecipes.generateShapelessRecipes(exporter);

        StairRecipes.generateShapedRecipes(exporter);
        StairRecipes.generateShapelessRecipes(exporter);

        RoseGoldTools.generateShapedRecipes(exporter);
        RoseGoldTools.generateShapelessRecipes(exporter);

        ArmorRecipes.generateShapedRecipes(exporter);
        ArmorRecipes.generateShapelessRecipes(exporter);

//        offerSmelting(exporter, List.of(ModItems.COPPER_GOLD_ALLOY), ModItems.ROSE_GOLD_INGOT,
//                0.25f, 200, "rose_gold");
//
//        offerBlasting(exporter, List.of(ModItems.COPPER_GOLD_ALLOY), ModItems.ROSE_GOLD_INGOT,
//                0.25f, 100, "rose_gold");
    }
}
