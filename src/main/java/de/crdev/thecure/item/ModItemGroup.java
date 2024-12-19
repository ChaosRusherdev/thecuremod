package de.crdev.thecure.item;


import de.crdev.thecure.TheCureMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup THE_CURE_ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(TheCureMod.MOD_ID, "the_cure_group"),
            () -> new ItemStack(ModItems.SCULC_ACID_JAR));

}
