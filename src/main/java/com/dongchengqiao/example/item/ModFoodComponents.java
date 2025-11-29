package com.dongchengqiao.example.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent New_Food = new FoodComponent.Builder().nutrition(8/*饥饿值*/).saturationModifier(0.8f/*倍饱食度乘数*/)/*.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,600),0.5f)效果*/.build();
}
