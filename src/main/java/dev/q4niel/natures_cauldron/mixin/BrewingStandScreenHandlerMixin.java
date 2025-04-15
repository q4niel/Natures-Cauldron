package dev.q4niel.natures_cauldron.mixin;

import dev.q4niel.natures_cauldron.NaturesCauldron;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "net.minecraft.screen.BrewingStandScreenHandler$FuelSlot")
public class BrewingStandScreenHandlerMixin {
    /**Bombardiro Crocodilo{@author q4niel}{@reason}*/ @Overwrite
    public static boolean matches(ItemStack stack) {
        return stack.isOf(Registries.ITEM.get(Identifier.of (
                NaturesCauldron.INSTANCE.getServerConfig().getBrewingStandFuelIngredient()
        )));
    }
}