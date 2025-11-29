package com.dongchengqiao.example.datagen;

import com.dongchengqiao.example.block.ModBlocks;
import com.dongchengqiao.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanProvider extends FabricLanguageProvider {


    public ModZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zn_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.New_Item,"新物品");
        translationBuilder.add(ModBlocks.New_Block,"新方块");
        translationBuilder.add(ModItems.New_Food,"新食物");
    }
}
