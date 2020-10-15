package com.sammy.malum.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class ModItemTiers
{
    public static final ItemTier SPIRITED_STEEL_ITEM = new ItemTier(3, 880, 7.0F, 2.5F, 12,() -> Ingredient.fromItems(ModItems.spirited_steel_ingot));
    public static final ItemTier UMBRAL_ALLOY_ITEM = new ItemTier(5, 1820, 9.0F, 4F, 24,() -> Ingredient.fromItems(ModItems.umbral_steel_ingot));
    
    public static final ArmorTier SPIRITED_STEEL_ARMOR = new ArmorTier("spirited_steel_armor", 18, new int[]{2, 5, 7, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, () -> Ingredient.fromItems(ModItems.spirited_steel_ingot), 0);
    
    public static final ArmorTier SPIRIT_HUNTER_ARMOR = new ArmorTier("spirit_hunter_armor", 18, new int[]{2, 4, 6, 1}, 32, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.5F, () -> Ingredient.fromItems(ModItems.spirit_fabric), 0);
    
    public static final ArmorTier UMBRAL_ALLOY_ARMOR = new ArmorTier("umbral_alloy_armor", 25, new int[]{7, 10, 8, 5}, 24, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F, () -> Ingredient.fromItems(ModItems.umbral_steel_ingot), 1);
    
    private static class ItemTier implements IItemTier
    {
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;
    
        public ItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterialSupplier)
        {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
        }
    
        @Override
        public int getMaxUses()
        {
            return maxUses;
        }
    
        @Override
        public float getEfficiency()
        {
            return efficiency;
        }
    
        @Override
        public float getAttackDamage()
        {
            return attackDamage;
        }
    
        @Override
        public int getHarvestLevel()
        {
            return harvestLevel;
        }
    
        @Override
        public int getEnchantability()
        {
            return enchantability;
        }
    
        @Override
        public Ingredient getRepairMaterial()
        {
            return this.repairMaterial.getValue();
        }
    }
    
    private static class ArmorTier implements IArmorMaterial
    {
        private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;
        private final float knockbackResistance;
    
        private ArmorTier(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughness, Supplier<Ingredient> repairMaterialSupplier, float knockbackResistance)
        {
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountsIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = equipSoundIn;
            this.toughness = toughness;
            this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
            this.knockbackResistance = knockbackResistance;
        }
    
        @Override
        public int getDurability(EquipmentSlotType slotIn)
        {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }
    
        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn)
        {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }
    
        @Override
        public int getEnchantability()
        {
            return this.enchantability;
        }
    
        @Override
        public SoundEvent getSoundEvent()
        {
            return this.soundEvent;
        }
    
        @Override
        public Ingredient getRepairMaterial()
        {
            return this.repairMaterial.getValue();
        }
    
        @OnlyIn(Dist.CLIENT)
        public String getName()
        {
            return this.name;
        }
    
        @Override
        public float getToughness()
        {
            return this.toughness;
        }
    
        @Override
        public float getKnockbackResistance()
        {
            return knockbackResistance;
        }
    }
}