package net.modcito;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.modcito.datagen.ModLootTableProvider;
import net.modcito.datagen.ModModelProvider;
import net.modcito.datagen.ModRecipeProvider;

public class ModcitoDataGenerator implements DataGeneratorEntrypoint {

  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

    pack.addProvider(ModModelProvider::new);
    pack.addProvider(ModLootTableProvider::new);
    pack.addProvider(ModRecipeProvider::new);
  }

}
