package it.francesco.tieniinmano;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public final class ManoRenderer extends ItemRenderer{
 public ManoRenderer(Minecraft mc){super(mc);}
 @Override public void renderItemInFirstPerson(float partialTicks){GlStateManager.pushMatrix();EntityPlayer p=Minecraft.getMinecraft().thePlayer;if(p!=null)Pose.applica(p.getHeldItem(),p.swingProgress,TieniInMano.config);super.renderItemInFirstPerson(partialTicks);GlStateManager.popMatrix();}
}
