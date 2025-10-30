package net.modcito.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.modcito.block.ModBlocks;
import net.modcito.block.custom.RiceCropBlock;
import net.modcito.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

  public ModLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  public void generate() {
   addDrop(Blocks.SUNFLOWER, ModItems.OIL);

   BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
     .properties(StatePredicate.Builder.create().exactMatch(RiceCropBlock.AGE, RiceCropBlock.MAX_AGE));

   this.addDrop(ModBlocks.RICE_CROP, this.cropDrops(ModBlocks.RICE_CROP, ModItems.RICE_SEEDS, ModItems.RICE_SEEDS, builder2));
  }
}
