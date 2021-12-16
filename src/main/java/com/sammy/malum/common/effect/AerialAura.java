package com.sammy.malum.common.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.MobEffect;
import net.minecraft.potion.EffectType;

public class AerialAura extends MobEffect
{
    public AerialAura()
    {
        super(EffectType.BENEFICIAL, 3401115);
        addAttributeModifier(Attributes.MOVEMENT_SPEED, "e3f9c028-d6cc-4cf2-86a6-d5b5efd86be6", 0.2f, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
    
    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier)
    {
    }
}