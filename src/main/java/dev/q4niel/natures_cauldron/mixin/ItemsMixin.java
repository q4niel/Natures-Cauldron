package dev.q4niel.natures_cauldron.mixin;

import dev.q4niel.natures_cauldron.NaturesCauldron;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Items.class)
public class ItemsMixin {

    @ModifyArgs (
            method = "register(Ljava/lang/String;Ljava/util/function/Function;)Lnet/minecraft/item/Item;",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/Items;register(Lnet/minecraft/registry/RegistryKey;Ljava/util/function/Function;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;"
            )
    )
    private static void foo(Args args) {
        Args mod = register(args);
        for (int i = 0; i < args.size(); i++) {
            args.set(i, mod.get(i));
        }
    }

    @ModifyArgs (
            method = "register(Ljava/lang/String;Ljava/util/function/Function;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/Items;register(Lnet/minecraft/registry/RegistryKey;Ljava/util/function/Function;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;"
            )
    )
    private static void bar(Args args) {
        Args mod = register(args);
        for (int i = 0; i < args.size(); i++) {
            args.set(i, mod.get(i));
        }
    }

    private static Item.Settings maxCount(Item.Settings settings, int value) {
        return settings.maxCount(value);
    }

    private static Args register(Args args) {
        switch (((RegistryKey)args.get(0)).getValue().toTranslationKey().toString()) {
            case "minecraft.glass_bottle": {
                args.set(2, maxCount(args.get(2), NaturesCauldron.INSTANCE.getServerConfig().getGlassBottleMaxCount()));
                break;
            }

            case "minecraft.potion": {
                args.set(2, maxCount(args.get(2), NaturesCauldron.INSTANCE.getServerConfig().getPotionMaxCount()));
                break;
            }

            case "minecraft.splash_potion": {
                args.set(2, maxCount(args.get(2), NaturesCauldron.INSTANCE.getServerConfig().getSplashPotionMaxCount()));
                break;
            }

            case "minecraft.lingering_potion": {
                args.set(2, maxCount(args.get(2), NaturesCauldron.INSTANCE.getServerConfig().getLingeringPotionMaxCount()));
                break;
            }
        }

        return args;
    }
}