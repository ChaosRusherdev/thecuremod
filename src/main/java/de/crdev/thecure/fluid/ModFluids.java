package de.crdev.thecure.fluid;

import de.crdev.thecure.TheCureMod;
import net.minecraft.block.Block;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public final static FlowableFluid STILL_SCULC_ACID = registerFluid("sculc_acid",
            new SculcAcidFluid.Still());

    public final static FlowableFluid FLOWING_SCULC_ACID = registerFluid("flowing_sculc_acid",
            new SculcAcidFluid.Flowing());


    private static FlowableFluid registerFluid(String name, FlowableFluid fluid) {
        Identifier fluidID = Identifier.of(TheCureMod.MOD_ID, name);

        return Registry.register(Registries.FLUID, fluidID, fluid);
    }

    public static void registerModFluids() {
        TheCureMod.LOGGER.info("Registering Mod Fluids for " + TheCureMod.MOD_ID);
    }
}
