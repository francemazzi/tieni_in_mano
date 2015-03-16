package it.francesco.tieniinmano.mescole;

import com.mojang.blaze3d.vertex.PoseStack;
import it.francesco.tieniinmano.Cliente;
import it.francesco.tieniinmano.Pose;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public final class ManoMixin{
 @Inject(method="renderArmWithItem",at=@At(value="INVOKE",target="Lnet/minecraft/client/renderer/ItemInHandRenderer;renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;I)V"))
 void tieni(AbstractClientPlayer g,float tick,float pitch,InteractionHand mano,float colpo,ItemStack pila,float equip,PoseStack pose,SubmitNodeCollector buffer,int luce,CallbackInfo ci){if(Cliente.config!=null&&(mano==InteractionHand.MAIN_HAND||Cliente.config.manoSecondaria()))Pose.applica(pose,mano==InteractionHand.MAIN_HAND?g.getMainArm():g.getMainArm().getOpposite(),pila,colpo,Cliente.config);}
}
