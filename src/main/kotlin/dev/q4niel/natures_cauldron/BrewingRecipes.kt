package dev.q4niel.natures_cauldron

import net.minecraft.item.Item
import net.minecraft.potion.Potion
import net.minecraft.registry.entry.RegistryEntry

data class ItemRecipe (
    val input: Item,
    val ingredient: Item,
    val output: Item
)

data class PotionRecipe (
    val input: RegistryEntry<Potion>,
    val ingredient: Item,
    val output: RegistryEntry<Potion>
)