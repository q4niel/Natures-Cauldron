package dev.q4niel

import net.minecraft.potion.Potion
import net.minecraft.registry.entry.RegistryEntry

data class PotionPair (
    val a: RegistryEntry<Potion>?,
    val b: RegistryEntry<Potion>?
)