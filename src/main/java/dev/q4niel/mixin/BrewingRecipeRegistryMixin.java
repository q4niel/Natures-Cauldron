package dev.q4niel.mixin;

import dev.q4niel.PotionPair;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.BrewingRecipeRegistry.Builder;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.List;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
    private static Builder _builder;

    private static final Item _strongIngredient_ = Items.GLOWSTONE_DUST;
    private static final Item _longIngredient_ = Items.REDSTONE;
    private static final Item _awkwardIngredient_ = Items.NETHER_WART;
    private static final Item _splashIngredient_ = Items.GUNPOWDER;
    private static final Item _lingeringIngredient_ = Items.DRAGON_BREATH;
    private static final List<Item> _oppositeIngredients_ = List.of(Items.CRIMSON_FUNGUS, Items.WARPED_FUNGUS);

    @Inject (
        method = "create(Lnet/minecraft/resource/featuretoggle/FeatureSet;)Lnet/minecraft/recipe/BrewingRecipeRegistry;",
        at = @At("HEAD"),
        cancellable = true
    )
    private static void create(FeatureSet enabledFeatures, CallbackInfoReturnable<BrewingRecipeRegistry> cir) {
        _builder = new Builder(enabledFeatures);

        _builder.registerPotionType(Items.POTION);
        _builder.registerPotionType(Items.SPLASH_POTION);
        _builder.registerPotionType(Items.LINGERING_POTION);

        _builder.registerItemRecipe(Items.POTION, _splashIngredient_, Items.SPLASH_POTION);
        _builder.registerItemRecipe(Items.SPLASH_POTION, _lingeringIngredient_, Items.LINGERING_POTION);

        _builder.registerPotionRecipe(Potions.WATER, _strongIngredient_, Potions.THICK);
        _builder.registerPotionRecipe(Potions.WATER, _longIngredient_, Potions.MUNDANE);
        _builder.registerPotionRecipe(Potions.WATER, _awkwardIngredient_, Potions.AWKWARD);

        registerRecipes(_builder);
        cir.setReturnValue(_builder.build());
    }

    private static void registerPair(RegistryEntry<Potion> input, Item ingredient, PotionPair pair) {
        if (pair == null || pair.getA() == null) return;
        _builder.registerPotionRecipe(input, ingredient, pair.getA());

        if (pair.getB() != null) {
            for (Item opposite : _oppositeIngredients_) {
                _builder.registerPotionRecipe(pair.getA(), opposite, pair.getB());
            }
        }
    }

    private static void registerTree (
            Item ingredient,
            PotionPair base,
            PotionPair stronger,
            PotionPair longer
    ) {
        if (base == null || base.getA() == null) return;
        _builder.registerPotionRecipe(Potions.WATER, ingredient, Potions.MUNDANE);
        registerPair(Potions.AWKWARD, ingredient, base);
        registerPair(base.getA(), _strongIngredient_, stronger);
        registerPair(base.getA(), _longIngredient_, longer);
    }

    private static void registerRecipes(Builder builder) {
        // The Goofy Ones
        builder.registerRecipes(Items.BREEZE_ROD, Potions.WIND_CHARGED);
        builder.registerRecipes(Items.SLIME_BLOCK, Potions.OOZING);
        builder.registerRecipes(Items.STONE, Potions.INFESTED);
        builder.registerRecipes(Items.COBWEB, Potions.WEAVING);

        // Healing
        registerTree (
            Items.POPPY,
            new PotionPair(Potions.HEALING, Potions.HARMING),
            new PotionPair(Potions.STRONG_HEALING, Potions.STRONG_HARMING),
            null
        );

        // Harming
        registerTree (
            Items.CACTUS,
            new PotionPair(Potions.HARMING, Potions.HEALING),
            new PotionPair(Potions.STRONG_HARMING, Potions.STRONG_HEALING),
            null
        );

        // Regeneration
        registerTree (
            Items.ROSE_BUSH,
            new PotionPair(Potions.REGENERATION, Potions.POISON),
            new PotionPair(Potions.STRONG_REGENERATION, Potions.STRONG_POISON),
            new PotionPair(Potions.LONG_REGENERATION, Potions.LONG_POISON)
        );

        // Poison
        registerTree (
            Items.WITHER_ROSE,
            new PotionPair(Potions.POISON, Potions.REGENERATION),
            new PotionPair(Potions.STRONG_POISON, Potions.STRONG_REGENERATION),
            new PotionPair(Potions.LONG_POISON, Potions.LONG_REGENERATION)
        );

        // Swiftness
        registerTree (
            Items.SUGAR_CANE,
            new PotionPair(Potions.SWIFTNESS, Potions.SLOWNESS),
            new PotionPair(Potions.STRONG_SWIFTNESS, Potions.STRONG_SLOWNESS),
            new PotionPair(Potions.LONG_SWIFTNESS, Potions.LONG_SLOWNESS)
        );

        // Slowness
        registerTree (
            Items.MOSS_BLOCK,
            new PotionPair(Potions.SLOWNESS, Potions.SWIFTNESS),
            new PotionPair(Potions.STRONG_SLOWNESS, Potions.STRONG_SWIFTNESS),
            new PotionPair(Potions.LONG_SLOWNESS, Potions.LONG_SWIFTNESS)
        );

        // Strength
        registerTree (
            Items.AMETHYST_SHARD,
            new PotionPair(Potions.STRENGTH, Potions.WEAKNESS),
            new PotionPair(Potions.STRONG_STRENGTH, null),
            new PotionPair(Potions.LONG_STRENGTH, Potions.LONG_WEAKNESS)
        );

        // Weakness
        registerTree (
            Items.TALL_GRASS,
            new PotionPair(Potions.WEAKNESS, Potions.STRENGTH),
            null,
            new PotionPair(Potions.LONG_WEAKNESS, Potions.LONG_STRENGTH)
        );

        // Fire Resistance
        registerTree (
            Items.SUNFLOWER,
            new PotionPair(Potions.FIRE_RESISTANCE, null),
            null,
            new PotionPair(Potions.LONG_FIRE_RESISTANCE, null)
        );

        // Slow Falling
        registerTree (
            Items.VINE,
            new PotionPair(Potions.SLOW_FALLING, null),
            null,
            new PotionPair(Potions.LONG_SLOW_FALLING, null)
        );

        // Leaping
        registerTree (
            Items.LILY_PAD,
            new PotionPair(Potions.LEAPING, null),
            new PotionPair(Potions.STRONG_LEAPING, null),
            new PotionPair(Potions.LONG_LEAPING, null)
        );

        // Night Vision
        registerTree (
            Items.CARROT,
            new PotionPair(Potions.NIGHT_VISION, null),
            null,
            new PotionPair(Potions.LONG_NIGHT_VISION, null)
        );

        // Water Breathing
        registerTree (
            Items.SEAGRASS,
            new PotionPair(Potions.WATER_BREATHING, null),
            null,
            new PotionPair(Potions.LONG_WATER_BREATHING, null)
        );

        // Invisibility
        registerTree (
            Items.GLOW_LICHEN,
            new PotionPair(Potions.INVISIBILITY, null),
            null,
            new PotionPair(Potions.LONG_INVISIBILITY, null)
        );

        // Turtle Master
        registerTree (
            Items.POTATO,
            new PotionPair(Potions.TURTLE_MASTER, null),
            new PotionPair(Potions.STRONG_TURTLE_MASTER, null),
            new PotionPair(Potions.LONG_TURTLE_MASTER, null)
        );
    }
}