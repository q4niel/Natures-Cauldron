package dev.q4niel.natures_cauldron.mixin;

import dev.q4niel.natures_cauldron.NaturesCauldron;
import net.minecraft.item.Items;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
    @Inject (
            method = "create(Lnet/minecraft/resource/featuretoggle/FeatureSet;)Lnet/minecraft/recipe/BrewingRecipeRegistry;",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void create(FeatureSet enabledFeatures, CallbackInfoReturnable<BrewingRecipeRegistry> cir) {
        BrewingRecipeRegistry.Builder builder = new BrewingRecipeRegistry.Builder(enabledFeatures);
        builder.registerPotionType(Items.POTION);
        builder.registerPotionType(Items.SPLASH_POTION);
        builder.registerPotionType(Items.LINGERING_POTION);

        NaturesCauldron.INSTANCE.getRuntimeConfig().getItemRecipes().forEach (
                r -> builder.registerItemRecipe (
                        r.getInput(),
                        r.getIngredient(),
                        r.getOutput()
                )
        );

        NaturesCauldron.INSTANCE.getRuntimeConfig().getPotionRecipes().forEach (
                r -> builder.registerPotionRecipe (
                        r.getInput(),
                        r.getIngredient(),
                        r.getOutput()
                )
        );

        cir.setReturnValue(builder.build());
    }
}