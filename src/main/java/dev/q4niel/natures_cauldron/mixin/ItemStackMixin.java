package dev.q4niel.natures_cauldron.mixin;

import dev.q4niel.natures_cauldron.NaturesCauldron;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Inject (
            method = "isIn(Lnet/minecraft/registry/tag/TagKey;)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    void isIn(TagKey<Item> tag, CallbackInfoReturnable<Boolean> cir) {
        if (tag != ItemTags.BREWING_FUEL) return;

        Item selfItem = ((ItemStack)(Object)this).getItem();
        cir.setReturnValue (
                NaturesCauldron.INSTANCE.getRuntimeConfig().getFuelIngredients().contains(selfItem)
        );
    }
}