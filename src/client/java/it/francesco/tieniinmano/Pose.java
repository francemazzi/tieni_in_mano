package it.francesco.tieniinmano;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.*;

public final class Pose{
 public static void applica(PoseStack p,HumanoidArm b,ItemStack s,float colpo,Config c){if(!c.attivo()||s.isEmpty()||speciale(s))return;float q=c.intensita(),l=b==HumanoidArm.RIGHT?1:-1,o=c.oscillazione()?(float)Math.sin(colpo*Math.PI)*.04F*q:0;p.translate(.08F*l*q,-.1F*q+o,-.16F*q);p.mulPose(Axis.YP.rotationDegrees(12*l*q));p.mulPose(Axis.XP.rotationDegrees(-10*q));if(s.has(DataComponents.TOOL)||s.has(DataComponents.WEAPON))arma(p,l,q);else if(s.getItem() instanceof BlockItem)blocco(p,q);else if(s.has(DataComponents.FOOD)||s.getItem() instanceof PotionItem)cibo(p,l,q);else piatto(p,l,q);}
 static boolean speciale(ItemStack s){Item i=s.getItem();return i instanceof BowItem||i instanceof CrossbowItem||i instanceof ShieldItem||i instanceof TridentItem||i instanceof MapItem||i instanceof EmptyMapItem||s.getUseAnimation().hasCustomArmTransform();}
 static void arma(PoseStack p,float l,float q){p.translate(.03F*l*q,-.03F*q,.02F*q);p.mulPose(Axis.ZP.rotationDegrees(-18*l*q));p.mulPose(Axis.XP.rotationDegrees(-12*q));}
 static void blocco(PoseStack p,float q){p.translate(0,.03F*q,-.05F*q);p.scale(.86F,.86F,.86F);}
 static void cibo(PoseStack p,float l,float q){p.translate(.04F*l*q,.02F*q,-.02F*q);p.mulPose(Axis.ZP.rotationDegrees(10*l*q));p.scale(.92F,.92F,.92F);}
 static void piatto(PoseStack p,float l,float q){p.translate(.02F*l*q,.01F*q,-.01F*q);p.mulPose(Axis.ZP.rotationDegrees(6*l*q));}
}
