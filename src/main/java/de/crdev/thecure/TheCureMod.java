package de.crdev.thecure;

import de.crdev.thecure.block.ModBlocks;
import de.crdev.thecure.effect.ModEffects;
import de.crdev.thecure.entity.ModEntities;
import de.crdev.thecure.fluid.ModFluids;
import de.crdev.thecure.item.ModItemGroup;
import de.crdev.thecure.item.ModItems;
import de.crdev.thecure.particle.ModParticles;
import de.crdev.thecure.potion.ModPotions;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheCureMod implements ModInitializer {
	public static final String MOD_ID = "thecure";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		//ModRegistries.registerModStuffs();
		//ModEnchantments.registerModEnchantments();

		//ModSounds.registerSounds();
		//ModLootTableModifiers.modifyLootTables();

		//ModPaintings.registerPaintings();
		ModEffects.registerEffects();

		ModFluids.registerModFluids();

		ModPotions.registerPotions();
		ModParticles.registerParticles();

		//ModVillagers.registerVillagers();
		ModFluids.registerModFluids();

		//ModBlockEntities.registerBlockEntities();
		//ModScreenHandlers.registerScreenHandler();

		//ModRecipes.registerRecipes();
		//ModWorldGeneration.generateModWorldGeneration();

		ModEntities.registerModEntities();
	}
}