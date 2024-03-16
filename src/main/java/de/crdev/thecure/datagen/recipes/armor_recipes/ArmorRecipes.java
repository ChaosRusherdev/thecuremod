package de.crdev.thecure.datagen.recipes.armor_recipes;
import de.crdev.thecure.block.ModBlocks;
import de.crdev.thecure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

// Used for decorative blocks only, no functional blocks

public class ArmorRecipes {
    public static void generateShapelessRecipes(RecipeExporter exporter) {

    }

    public static void generateShapedRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOCTORS_GLASSES, 1)
                .pattern("   ")
                .pattern("gng")
                .pattern("   ")

                .input('g', Blocks.GLASS)
                .input('n', ModItems.ROSE_NETHERITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Blocks.GLASS),
                        FabricRecipeProvider.conditionsFromItem(Blocks.GLASS))
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROSE_NETHERITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ROSE_NETHERITE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOCTORS_COAT, 1)
                .pattern("l l")
                .pattern("lnl")
                .pattern("lbl")

                .input('l', Items.LEATHER)
                .input('n', ModItems.ROSE_NETHERITE_INGOT)
                .input('b', Items.BLACK_DYE)
                .criterion(FabricRecipeProvider.hasItem(Items.LEATHER),
                        FabricRecipeProvider.conditionsFromItem(Items.LEATHER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROSE_NETHERITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ROSE_NETHERITE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.BLACK_DYE),
                        FabricRecipeProvider.conditionsFromItem(Items.BLACK_DYE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOCTORS_BELT, 1)
                .pattern("   ")
                .pattern("lnl")
                .pattern("   ")

                .input('l', Items.LEATHER)
                .input('n', ModItems.ROSE_NETHERITE_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.LEATHER),
                        FabricRecipeProvider.conditionsFromItem(Items.LEATHER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.ROSE_NETHERITE_INGOT),
                        FabricRecipeProvider.conditionsFromItem(ModItems.ROSE_NETHERITE_INGOT))
                .offerTo(exporter);
    }
}
