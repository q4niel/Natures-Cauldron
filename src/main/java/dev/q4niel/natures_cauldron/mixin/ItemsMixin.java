package dev.q4niel.natures_cauldron.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Items.class)
public class ItemsMixin {

    // Modify Glass Bottle Max Count
    @ModifyArgs (
            method = "register(Ljava/lang/String;Ljava/util/function/Function;)Lnet/minecraft/item/Item;",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/Items;register(Lnet/minecraft/registry/RegistryKey;Ljava/util/function/Function;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;"
            )
    )
    private static void modifyRegisterArgs(Args args) {
        if (((RegistryKey)args.get(0)).getValue().toTranslationKey().equals("minecraft.glass_bottle")) {
            args.set(2, new Item.Settings().maxCount(16));
        }
    }
}