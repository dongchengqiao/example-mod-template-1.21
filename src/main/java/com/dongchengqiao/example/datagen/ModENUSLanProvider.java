package com.dongchengqiao.example.datagen;

import com.dongchengqiao.example.block.ModBlocks;
import com.dongchengqiao.example.block.entity.ModBlockEntities;
import com.dongchengqiao.example.item.ModItemGroups;
import com.dongchengqiao.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.New_Item,"New Item");
        translationBuilder.add(ModBlocks.New_Block,"New Block");
        translationBuilder.add(ModItems.New_Food,"New Food");
        translationBuilder.add(ModBlocks.Box, "Box");
        translationBuilder.add("container.box", "Box");

        translationBuilder.add("itemGroup.example_group", "Example Mod");
    }
}
