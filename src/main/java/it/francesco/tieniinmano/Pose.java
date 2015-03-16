package it.francesco.tieniinmano;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public final class Pose{
 public static void applica(ItemStack s,float colpo,Config c){if(c==null||!c.attivo()||s==null||speciale(s))return;float q=c.intensita(),o=c.oscillazione()?(float)Math.sin(colpo*Math.PI)*.04F*q:0;GlStateManager.translate(.08F*q,-.1F*q+o,-.16F*q);GlStateManager.rotate(12*q,0,1,0);GlStateManager.rotate(-10*q,1,0,0);Item i=s.getItem();if(i instanceof ItemSword||i instanceof ItemTool)arma(q);else if(i instanceof ItemBlock)blocco(q);else if(i instanceof ItemFood||i instanceof ItemPotion)cibo(q);else piatto(q);}
 static boolean speciale(ItemStack s){Item i=s.getItem();return i instanceof ItemBow||i instanceof ItemMap;}
 static void arma(float q){GlStateManager.translate(.03F*q,-.03F*q,.02F*q);GlStateManager.rotate(-18*q,0,0,1);GlStateManager.rotate(-12*q,1,0,0);}
 static void blocco(float q){GlStateManager.translate(0,.03F*q,-.05F*q);GlStateManager.scale(.86F,.86F,.86F);}
 static void cibo(float q){GlStateManager.translate(.04F*q,.02F*q,-.02F*q);GlStateManager.rotate(10*q,0,0,1);GlStateManager.scale(.92F,.92F,.92F);}
 static void piatto(float q){GlStateManager.translate(.02F*q,.01F*q,-.01F*q);GlStateManager.rotate(6*q,0,0,1);}
}
