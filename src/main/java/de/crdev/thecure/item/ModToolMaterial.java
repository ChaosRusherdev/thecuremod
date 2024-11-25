package de.crdev.thecure.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;


public enum ModToolMaterial implements ToolMaterial {
    ROSE_GOLD(3, 1500, 10.0f, 1.5f, 28),
    ROSE_NETHERITE(5, 2000, 12.0f, 1.5f, 28);

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                    int enchantability) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

}

