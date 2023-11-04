package io.fourleaves.earlyarmors.armor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags.Items;

public class WoodArmorMaterial implements ArmorMaterial {
	private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	private static final int[] DAMAGE_REDUCTION = new int[]{1, 1, 2, 1};

    @Override
    public int getDurabilityForType(Type type) {
        switch (type)
        {
        case HELMET:
            return MAX_DAMAGE_ARRAY[0] * 3;
        case LEGGINGS:
            return MAX_DAMAGE_ARRAY[1] * 3;
        case CHESTPLATE:
            return MAX_DAMAGE_ARRAY[2] * 3;
        case BOOTS:
            return MAX_DAMAGE_ARRAY[3] * 3;
        default:
            throw new IllegalArgumentException("Invalid armor type: " + type);
        }
    }

    @Override
    public int getDefenseForType(Type type) {
        switch (type)
        {
        case HELMET:
            return DAMAGE_REDUCTION[0];
        case LEGGINGS:
            return DAMAGE_REDUCTION[1];
        case CHESTPLATE:
            return DAMAGE_REDUCTION[2];
        case BOOTS:
            return DAMAGE_REDUCTION[3];
        default:
            throw new IllegalArgumentException("Invalid armor type: " + type);
        }
    }

    @Override
    public int getEnchantmentValue() {
        return 5; // TODO: ?
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemTags.PLANKS);
    }

    @Override
    public String getName() {
        return "earlyarmors:wood";
    }

    @Override
    public float getToughness() {
        return 1f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0f;
    }
}
