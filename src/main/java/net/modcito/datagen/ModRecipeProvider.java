package net.modcito.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.modcito.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

  public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
   return new RecipeGenerator(wrapperLookup, recipeExporter) {
    @Override
    public void generate() {

      createShaped(RecipeCategory.FOOD, ModItems.AREPA, 2)
        .pattern("fwc")
        .input('f', ModItems.FLOUR)
        .input('w', Items.WATER_BUCKET)
        .input('c', ModItems.CHEESE)
        .criterion(hasItem(ModItems.AREPA), conditionsFromItem(ModItems.AREPA))
        .offerTo(exporter);

      createShaped(RecipeCategory.FOOD, ModItems.BAGUETTE, 2)
        .pattern("wdw")
        .input('w', Items.WHEAT)
        .input('d', ModItems.DOUGH)
        .criterion(hasItem(ModItems.BAGUETTE), conditionsFromItem(ModItems.BAGUETTE))
        .offerTo(exporter);

      createShaped(RecipeCategory.FOOD, ModItems.BUTTER, 1)
        .pattern("ms")
        .input('m', Items.MILK_BUCKET)
        .input('s', ModItems.SALT)
        .criterion(hasItem(ModItems.BUTTER), conditionsFromItem(ModItems.BUTTER))
        .offerTo(exporter);

      createShaped(RecipeCategory.FOOD, ModItems.CHEESE, 4)
        .pattern("mk")
        .input('m', Items.MILK_BUCKET)
        .input('k', Items.DRIED_KELP)
        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
        .offerTo(exporter);

      createShaped(RecipeCategory.FOOD, ModItems.DOUGH, 10)
        .pattern("bfs")
        .pattern("Sym")
        .input('b', ModItems.BUTTER)
        .input('f', ModItems.FLOUR)
        .input('s', Items.SUGAR)
        .input('S', ModItems.SALT)
        .input('y', ModItems.YEAST)
        .input('m', Items.MILK_BUCKET)
        .criterion(hasItem(ModItems.DOUGH), conditionsFromItem(ModItems.DOUGH))
        .offerTo(exporter);

      createShapeless(RecipeCategory.FOOD, ModItems.FLOUR, 2)
        .input(Items.WHEAT)
        .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.FLOUR))
        .offerTo(exporter);

      createShapeless(RecipeCategory.FOOD, ModItems.SALT, 5)
        .input(Items.DRIED_KELP)
        .criterion(hasItem(ModItems.SALT), conditionsFromItem(ModItems.SALT))
        .offerTo(exporter);

      createShaped(RecipeCategory.FOOD, ModItems.SUSHI, 4)
        .pattern("Ssr")
        .input('S', Items.SALMON)
        .input('s', Items.DRIED_KELP)
        .input('r', ModItems.RICE_BOWL)
        .criterion(hasItem(ModItems.SUSHI), conditionsFromItem(ModItems.SUSHI))
        .offerTo(exporter);

      createShaped(RecipeCategory.FOOD, ModItems.RICE_BOWL)
        .pattern("rrr")
        .pattern(" b ")
        .input('r', ModItems.RICE_SEEDS)
        .input('b', Items.BOWL)
        .criterion(hasItem(ModItems.RICE_BOWL), conditionsFromItem(ModItems.RICE_BOWL))
        .offerTo(exporter);

      createShaped(RecipeCategory.FOOD, ModItems.YEAST, 3)
        .pattern("swb")
        .input('s', Items.SUGAR)
        .input('w', Items.WHEAT)
        .input('b', Items.WATER_BUCKET)
        .criterion(hasItem(ModItems.YEAST), conditionsFromItem(ModItems.YEAST))
        .offerTo(exporter);

      offerSmelting(
        List.of(ModItems.DOUGH),
        RecipeCategory.FOOD,
        ModItems.CROISSANT,
        0.1f,
        300,
        "dough_to_croissant");
      }
    };
  }

  @Override
  public String getName() {
    return "Modcito Recipes";
  }

}
