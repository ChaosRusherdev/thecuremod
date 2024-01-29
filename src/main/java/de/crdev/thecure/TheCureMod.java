package de.crdev.thecure;

import de.crdev.thecure.item.ModItemGroup;
import de.crdev.thecure.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheCureMod implements ModInitializer {
	public static final String MOD_ID = "thecure";
    public static final Logger LOGGER = LoggerFactory.getLogger("thecuremod");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
	}
}