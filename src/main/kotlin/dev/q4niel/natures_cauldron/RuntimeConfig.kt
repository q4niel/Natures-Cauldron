package dev.q4niel.natures_cauldron

import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.potion.Potions

data class RuntimeConfig (
    val fuelIngredients: List<Item> = listOf(Items.CHARCOAL),
    val itemRecipes: List<ItemRecipe> = listOf (
        ItemRecipe(Items.POTION, Items.GUNPOWDER, Items.SPLASH_POTION),
        ItemRecipe(Items.SPLASH_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION)
    ),
    val potionRecipes: List<PotionRecipe> = listOf (
        //region Awkward
        PotionRecipe(Potions.WATER, Items.RED_MUSHROOM, Potions.AWKWARD),
        PotionRecipe(Potions.WATER, Items.BROWN_MUSHROOM, Potions.AWKWARD),
        //endregion
        //region Healing
        PotionRecipe(Potions.AWKWARD, Items.POPPY, Potions.HEALING),
        PotionRecipe(Potions.HEALING, Items.POPPY, Potions.STRONG_HEALING),
        // Reversed
        PotionRecipe(Potions.HARMING, Items.WARPED_FUNGUS, Potions.HEALING),
        PotionRecipe(Potions.HARMING, Items.CRIMSON_FUNGUS, Potions.HEALING),
        PotionRecipe(Potions.STRONG_HARMING, Items.WARPED_FUNGUS, Potions.STRONG_HEALING),
        PotionRecipe(Potions.STRONG_HARMING, Items.CRIMSON_FUNGUS, Potions.STRONG_HEALING),
        //endregion
        //region Regeneration
        PotionRecipe(Potions.AWKWARD, Items.ROSE_BUSH, Potions.REGENERATION),
        PotionRecipe(Potions.REGENERATION, Items.ROSE_BUSH, Potions.STRONG_REGENERATION),
        PotionRecipe(Potions.REGENERATION, Items.SUGAR, Potions.LONG_REGENERATION),
        // Reversed
        PotionRecipe(Potions.POISON, Items.WARPED_FUNGUS, Potions.REGENERATION),
        PotionRecipe(Potions.POISON, Items.CRIMSON_FUNGUS, Potions.REGENERATION),
        PotionRecipe(Potions.STRONG_REGENERATION, Items.WARPED_FUNGUS, Potions.STRONG_REGENERATION),
        PotionRecipe(Potions.STRONG_REGENERATION, Items.CRIMSON_FUNGUS, Potions.STRONG_REGENERATION),
        PotionRecipe(Potions.LONG_REGENERATION, Items.WARPED_FUNGUS, Potions.LONG_REGENERATION),
        PotionRecipe(Potions.LONG_REGENERATION, Items.CRIMSON_FUNGUS, Potions.LONG_REGENERATION),
        //endregion
        //region Swiftness
        PotionRecipe(Potions.AWKWARD, Items.SUGAR_CANE, Potions.SWIFTNESS),
        PotionRecipe(Potions.SWIFTNESS, Items.SUGAR_CANE, Potions.STRONG_SWIFTNESS),
        PotionRecipe(Potions.SWIFTNESS, Items.SUGAR, Potions.LONG_SWIFTNESS),
        // Reversed
        PotionRecipe(Potions.SLOWNESS, Items.WARPED_FUNGUS, Potions.SWIFTNESS),
        PotionRecipe(Potions.SLOWNESS, Items.CRIMSON_FUNGUS, Potions.SWIFTNESS),
        PotionRecipe(Potions.STRONG_SLOWNESS, Items.WARPED_FUNGUS, Potions.STRONG_SWIFTNESS),
        PotionRecipe(Potions.STRONG_SLOWNESS, Items.CRIMSON_FUNGUS, Potions.STRONG_SWIFTNESS),
        PotionRecipe(Potions.LONG_SLOWNESS, Items.WARPED_FUNGUS, Potions.LONG_SWIFTNESS),
        PotionRecipe(Potions.LONG_SLOWNESS, Items.CRIMSON_FUNGUS, Potions.LONG_SWIFTNESS),
        //endregion
        //region Strength
        PotionRecipe(Potions.AWKWARD, Items.AMETHYST_SHARD, Potions.STRENGTH),
        PotionRecipe(Potions.STRENGTH, Items.AMETHYST_SHARD, Potions.STRONG_STRENGTH),
        PotionRecipe(Potions.STRENGTH, Items.SUGAR, Potions.LONG_STRENGTH),
        // Reversed
        PotionRecipe(Potions.WEAKNESS, Items.WARPED_FUNGUS, Potions.STRENGTH),
        PotionRecipe(Potions.WEAKNESS, Items.CRIMSON_FUNGUS, Potions.STRENGTH),
        PotionRecipe(Potions.LONG_WEAKNESS, Items.WARPED_FUNGUS, Potions.LONG_STRENGTH),
        PotionRecipe(Potions.LONG_WEAKNESS, Items.CRIMSON_FUNGUS, Potions.LONG_STRENGTH),
        //endregion
        //region Fire Resistance
        PotionRecipe(Potions.AWKWARD, Items.SUNFLOWER, Potions.FIRE_RESISTANCE),
        PotionRecipe(Potions.FIRE_RESISTANCE, Items.SUGAR, Potions.LONG_FIRE_RESISTANCE),
        //endregion
        //region Slow Falling
        PotionRecipe(Potions.AWKWARD, Items.VINE, Potions.SLOW_FALLING),
        PotionRecipe(Potions.SLOW_FALLING, Items.SUGAR, Potions.LONG_SLOW_FALLING),
        //endregion
        //region Leaping
        PotionRecipe(Potions.AWKWARD, Items.LILY_PAD, Potions.LEAPING),
        PotionRecipe(Potions.LEAPING, Items.LILY_PAD, Potions.STRONG_LEAPING),
        PotionRecipe(Potions.LEAPING, Items.SUGAR, Potions.LONG_LEAPING),
        //endregion
        //region Night Vision
        PotionRecipe(Potions.AWKWARD, Items.CARROT, Potions.NIGHT_VISION),
        PotionRecipe(Potions.NIGHT_VISION, Items.SUGAR, Potions.LONG_NIGHT_VISION),
        //endregion
        //region Water Breathing
        PotionRecipe(Potions.AWKWARD, Items.SEAGRASS, Potions.WATER_BREATHING),
        PotionRecipe(Potions.WATER_BREATHING, Items.SUGAR, Potions.LONG_WATER_BREATHING),
        //endregion
        //region Invisibility
        PotionRecipe(Potions.AWKWARD, Items.GLOW_LICHEN, Potions.INVISIBILITY),
        PotionRecipe(Potions.INVISIBILITY, Items.SUGAR, Potions.LONG_INVISIBILITY),
        //endregion
        //region Turtle Master
        PotionRecipe(Potions.AWKWARD, Items.POTATO, Potions.TURTLE_MASTER),
        PotionRecipe(Potions.TURTLE_MASTER, Items.POTATO, Potions.STRONG_TURTLE_MASTER),
        PotionRecipe(Potions.TURTLE_MASTER, Items.SUGAR, Potions.LONG_TURTLE_MASTER),
        //endregion
        //region Harming
        PotionRecipe(Potions.AWKWARD, Items.CACTUS, Potions.HARMING),
        PotionRecipe(Potions.HARMING, Items.CACTUS, Potions.STRONG_HARMING),
        // Reversed
        PotionRecipe(Potions.HEALING, Items.WARPED_FUNGUS, Potions.HARMING),
        PotionRecipe(Potions.HEALING, Items.CRIMSON_FUNGUS, Potions.HARMING),
        PotionRecipe(Potions.STRONG_HEALING, Items.WARPED_FUNGUS, Potions.STRONG_HARMING),
        PotionRecipe(Potions.STRONG_HEALING, Items.CRIMSON_FUNGUS, Potions.STRONG_HARMING),
        //endregion
        //region Poison
        PotionRecipe(Potions.AWKWARD, Items.WITHER_ROSE, Potions.POISON),
        PotionRecipe(Potions.POISON, Items.WITHER_ROSE, Potions.STRONG_POISON),
        PotionRecipe(Potions.POISON, Items.SUGAR, Potions.LONG_POISON),
        // Reversed
        PotionRecipe(Potions.REGENERATION, Items.WARPED_FUNGUS, Potions.POISON),
        PotionRecipe(Potions.REGENERATION, Items.CRIMSON_FUNGUS, Potions.POISON),
        PotionRecipe(Potions.STRONG_REGENERATION, Items.WARPED_FUNGUS, Potions.STRONG_REGENERATION),
        PotionRecipe(Potions.STRONG_REGENERATION, Items.CRIMSON_FUNGUS, Potions.STRONG_REGENERATION),
        PotionRecipe(Potions.LONG_REGENERATION, Items.WARPED_FUNGUS, Potions.LONG_REGENERATION),
        PotionRecipe(Potions.LONG_REGENERATION, Items.CRIMSON_FUNGUS, Potions.LONG_REGENERATION),
        //endregion
        //region Slowness
        PotionRecipe(Potions.AWKWARD, Items.MOSS_BLOCK, Potions.SLOWNESS),
        PotionRecipe(Potions.SLOWNESS, Items.MOSS_BLOCK, Potions.STRONG_SLOWNESS),
        PotionRecipe(Potions.SLOWNESS, Items.SUGAR, Potions.LONG_SLOWNESS),
        // Reversed
        PotionRecipe(Potions.SWIFTNESS, Items.WARPED_FUNGUS, Potions.SLOWNESS),
        PotionRecipe(Potions.SWIFTNESS, Items.CRIMSON_FUNGUS, Potions.SLOWNESS),
        PotionRecipe(Potions.STRONG_SWIFTNESS, Items.WARPED_FUNGUS, Potions.STRONG_SLOWNESS),
        PotionRecipe(Potions.STRONG_SWIFTNESS, Items.CRIMSON_FUNGUS, Potions.STRONG_SLOWNESS),
        PotionRecipe(Potions.LONG_SWIFTNESS, Items.WARPED_FUNGUS, Potions.LONG_SLOWNESS),
        PotionRecipe(Potions.LONG_SWIFTNESS, Items.CRIMSON_FUNGUS, Potions.LONG_SLOWNESS),
        //endregion
        //region Weakness
        PotionRecipe(Potions.AWKWARD, Items.TALL_GRASS, Potions.WEAKNESS),
        PotionRecipe(Potions.WEAKNESS, Items.SUGAR, Potions.LONG_WEAKNESS),
        // Reversed
        PotionRecipe(Potions.STRENGTH, Items.WARPED_FUNGUS, Potions.WEAKNESS),
        PotionRecipe(Potions.STRENGTH, Items.CRIMSON_FUNGUS, Potions.WEAKNESS),
        PotionRecipe(Potions.LONG_STRENGTH, Items.WARPED_FUNGUS, Potions.LONG_WEAKNESS),
        PotionRecipe(Potions.LONG_STRENGTH, Items.CRIMSON_FUNGUS, Potions.LONG_WEAKNESS),
        //endregion
    )
)