package de.crdev.thecure.tags;

import de.crdev.thecure.TheCureMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_ROSEGOLD_TOOL = createTag("incorrect_for_rosegold_tool");

        public static final TagKey<Block> SCULC_ACID_REACTIVE_ORES =
                TagKey.of(RegistryKeys.BLOCK, Identifier.of(TheCureMod.MOD_ID, "sculc_acid_reactive_ores"));

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TheCureMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TheCureMod.MOD_ID, name));
        }
    }
}
