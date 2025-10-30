package net.modcito.block;

import java.util.function.Function;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.modcito.Modcito;
import net.modcito.block.custom.RiceCropBlock;

public class ModBlocks {

  public static final Block RICE_CROP = register("rice_crop",
      props -> new RiceCropBlock(
        props.noCollision()
          .ticksRandomly()
          .breakInstantly()
          .sounds(BlockSoundGroup.CROP)
          .pistonBehavior(PistonBehavior.DESTROY)
        ));

  public static void init() {

  }

  private static Block register(String name, Function<AbstractBlock.Settings, Block> function) {
    return Registry.register(Registries.BLOCK, Identifier.of(Modcito.MOD_ID, name),
        function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Modcito.MOD_ID, name)))));
  }

}
