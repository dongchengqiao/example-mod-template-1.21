package com.dongchengqiao.example.item;

import com.dongchengqiao.example.ExampleMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //第一个物品
    public static final Item New_Item = registerItem("new_item", new Item(new Item.Settings()));

    private static Item registerItem(String  id, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID,id), item);
//      return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(ExampleMod.MOD_ID,id)),item);
    }

    //加载
    public static void registerItems() {
        ExampleMod.LOGGER.info("Registering Items");
    }
}
