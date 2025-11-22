package com.dongchengqiao.example;

import com.dongchengqiao.example.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ExampleModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModBlockTagsProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModENUSLanProvider::new);
        pack.addProvider(ModZHCNLanProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
	}
}
