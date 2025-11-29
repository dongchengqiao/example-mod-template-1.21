package com.dongchengqiao.example.item;

import com.dongchengqiao.example.ExampleMod;
import com.dongchengqiao.example.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

//    public static final RegistryKey<ItemGroup> EXAMPLE_GROUP = register("example_group");
//
//    private static RegistryKey<ItemGroup> register(String id) {
//        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(ExampleMod.MOD_ID, id));
//    }
//
//    public static void registerModItemGroups() {
//        Registry.register(Registries.ITEM_GROUP, EXAMPLE_GROUP
//                , ItemGroup.create(ItemGroup.Row.TOP, 7)
//                                .displayName(Text.translatable("itemGroup.example_group"))
//                                .icon(() -> new ItemStack(ModItems.New_Item))
//                        .entries((displayContext, entries) -> {
//                            entries.add(ModItems.New_Item);
//                        })
//                        .build());
//        ExampleMod.LOGGER.info("Registering ModItemGroups");
//    }
    public static final ItemGroup EXAMPLE_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(ExampleMod.MOD_ID, "example_group"),
        ItemGroup.create(null, -1).displayName(Text.translatable("itemGroup.example_group"))
                .icon(() -> new ItemStack(ModItems.New_Item))
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.New_Item);
                    entries.add(ModBlocks.New_Block);
                    entries.add(ModItems.New_Food);
                })
                .build()
        );
    public static void registerModItemGroups(){
        ExampleMod.LOGGER.info("Registering Item Groups");
    }
}
