package com.dongchengqiao.example.block;

import com.dongchengqiao.example.ExampleMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block New_Block = register("new_block", new Block(AbstractBlock.Settings.create().strength(3.0f, 3.0f)));

    public static void registerBlockItems(String id, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ExampleMod.MOD_ID, id), new BlockItem(block, new Item.Settings()));
    }
    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ExampleMod.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        ExampleMod.LOGGER.info("Registering ModBlocks");
    }
}
