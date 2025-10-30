package net.modcito.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.modcito.Modcito;
import net.modcito.block.ModBlocks;
import net.modcito.component.type.ModFoodComponents;

import java.util.function.Function;

public class ModItems {

  public static Item AREPA = register("arepa",
      settings -> new Item(settings.food(ModFoodComponents.AREPA)));

  public static Item BAGUETTE = register("baguette",
      settings -> new Item(settings.food(ModFoodComponents.BAGUETTE)));

  public static Item BUTTER = register("butter", Item::new);

  public static Item CHEESE = register("cheese",
      settings -> new Item(settings.food(ModFoodComponents.CHEESE)));

  public static Item CROISSANT = register("croissant",
      settings -> new Item(settings.food(ModFoodComponents.CROISSANT)));

  public static Item DOUGH = register("dough", Item::new);

  public static Item FLOUR = register("flour", Item::new);

  public static Item OIL = register("oil", Item::new);

  public static Item PATACONES = register("patacones",
      settings -> new Item(settings.food(ModFoodComponents.PATACONES)));

  public static Item RICE_BOWL = register("rice_bowl",
      settings -> new Item(settings.food(ModFoodComponents.RICE_BOWL)));

  public static Item RICE_SEEDS = register("rice_seeds",
      settings -> new BlockItem(ModBlocks.RICE_CROP, settings));

  public static Item SALT = register("salt", Item::new);

  public static Item SUSHI = register("sushi",
      settings -> new Item(settings.food(ModFoodComponents.SUSHI)));

  public static Item YEAST = register("yeast", Item::new);

  private static Item register(String name, Function<Item.Settings, Item> function) {
    return Registry.register(Registries.ITEM, Identifier.of(Modcito.MOD_ID, name),
        function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Modcito.MOD_ID, name)))));
  }

  public static void init() {
    
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
      .register((g) -> {
        g.add(AREPA);
        g.add(BAGUETTE);
        g.add(CHEESE);
        g.add(CROISSANT);
        g.add(PATACONES);
        g.add(RICE_BOWL);
        g.add(RICE_SEEDS);
        g.add(SUSHI);
    });

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
      .register((g) -> {
        g.add(BUTTER);
        g.add(DOUGH);
        g.add(FLOUR);
        g.add(OIL);
        g.add(SALT);
        g.add(YEAST);
    });
  }
}
