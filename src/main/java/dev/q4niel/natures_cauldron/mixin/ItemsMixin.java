package dev.q4niel.natures_cauldron.mixin;

import dev.q4niel.natures_cauldron.StaticConfig;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Items.class)
public class ItemsMixin {

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/GlassBottleItem;<init>(Lnet/minecraft/item/Item$Settings;)V"
            )
    )
    private static Item.Settings GlassBottleItem(Item.Settings settings) {
        return settings.maxCount(StaticConfig.GLASS_BOTTLE_MAX_COUNT);
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/PotionItem;<init>(Lnet/minecraft/item/Item$Settings;)V"
            )
    )
    private static Item.Settings PotionItem(Item.Settings settings) {
        return settings.maxCount(StaticConfig.POTION_MAX_COUNT);
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/SplashPotionItem;<init>(Lnet/minecraft/item/Item$Settings;)V"
            )
    )
    private static Item.Settings SplashPotionItem(Item.Settings settings) {
        return settings.maxCount(StaticConfig.SPLASH_POTION_MAX_COUNT);
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/LingeringPotionItem;<init>(Lnet/minecraft/item/Item$Settings;)V"
            )
    )
    private static Item.Settings LingeringPotionItem(Item.Settings settings) {
        return settings.maxCount(StaticConfig.LINGERING_POTION_MAX_COUNT);
    }
}