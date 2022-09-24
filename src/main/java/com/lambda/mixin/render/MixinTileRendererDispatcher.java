package com.lambda.mixin.render;

import com.lambda.client.module.modules.render.Xray;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TileEntityRendererDispatcher.class)
public class MixinTileRendererDispatcher {

    @Inject(method = "render(Lnet/minecraft/tileentity/TileEntity;FI)V", at = @At("HEAD"), cancellable = true)
    public void render(TileEntity tileEntityIn, float partialTicks, int destroyStage, CallbackInfo ci) {
        Block block;
        //noinspection ConstantConditions
        if (tileEntityIn != null
            && (block = tileEntityIn.getBlockType()) != null
            && Xray.shouldReplace(block.getDefaultState())) {
            ci.cancel();
        }
    }

}
