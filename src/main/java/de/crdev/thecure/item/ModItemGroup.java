package de.crdev.thecure.item;


import de.crdev.thecure.TheCureMod;
import de.crdev.thecure.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup THE_CURE_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheCureMod.MOD_ID, "the_cure_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.the_cure_group"))
                    .icon(() -> new ItemStack(ModItems.DOCTORS_GLASSES)).entries((displayContext, entries) -> {

                        entries.add(ModItems.DOCTORS_GLASSES);

                        entries.add(ModItems.COPPER_GOLD_ALLOY);
                        entries.add(ModItems.ROSE_GOLD_INGOT);

                        entries.add(ModItems.GLASS_JAR);
                        entries.add(ModItems.SCULC_ACID_JAR);
                        entries.add(ModItems.GLASS_VIAL);
                        entries.add(ModItems.SCULC_ACID_VIAL);

                        entries.add(ModItems.ROSE_GOLD_SWORD);
                        entries.add(ModItems.ROSE_GOLD_PICKAXE);
                        entries.add(ModItems.ROSE_GOLD_SHOVEL);
                        entries.add(ModItems.ROSE_GOLD_AXE);
                        entries.add(ModItems.ROSE_GOLD_HOE);


                        entries.add(ModBlocks.ROSE_GOLD_BLOCK);
                        entries.add(ModBlocks.ROSE_GOLD_BRICKS);
                        entries.add(ModBlocks.ROSE_GOLD_BRICK_STAIRS);
                        entries.add(ModBlocks.ROSE_GOLD_BRICK_SLAB);


                    }).build());

    public static void registerItemGroups() {

    }
}
