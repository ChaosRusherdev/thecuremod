package de.crdev.ui;

import de.crdev.thecure.TheCureMod;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ScreenHandlers {
    public static final ScreenHandlerType<CustomInventoryScreenHandler> CUSTOM_INVENTORY_SCREEN_HANDLER =
            Registry.register(Registry.SCREEN_HANDLER, new Identifier(TheCureMod.MOD_ID, "potion_gauntlet_inventory"),
                    new ScreenHandlerType<>((syncId, inventory) ->
                            new CustomInventoryScreenHandler(syncId, inventory, ScreenHandlerContext.EMPTY)));

    public static void registerScreenHandlers() {
        // This method should be called during mod initialization
    }
}
