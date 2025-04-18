package dev.q4niel.natures_cauldron.mixin;

import dev.q4niel.natures_cauldron.NaturesCauldron;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Inject (
            method = "isOf(Lnet/minecraft/item/Item;)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    void isOf(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (item != Items.BLAZE_POWDER) return;

        Item selfItem = ((ItemStack)(Object)this).getItem();
        cir.setReturnValue (
                NaturesCauldron.INSTANCE.getRuntimeConfig().getFuelIngredients().contains(selfItem)
        );
    }
}