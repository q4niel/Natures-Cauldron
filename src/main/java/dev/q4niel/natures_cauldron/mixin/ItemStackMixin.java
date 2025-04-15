package dev.q4niel.natures_cauldron.mixin;

import dev.q4niel.natures_cauldron.NaturesCauldron;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
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

        Identifier selfId = Registries.ITEM.getId (
                ((ItemStack)(Object)this).getItem()
        );

        Identifier desiredId = Identifier.of (
                NaturesCauldron.INSTANCE.getServerConfig().getBrewingStandFuelIngredient()
        );

        cir.setReturnValue(selfId.equals(desiredId));
    }
}