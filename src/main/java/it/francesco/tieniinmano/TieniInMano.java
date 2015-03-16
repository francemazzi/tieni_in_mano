package it.francesco.tieniinmano;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid="tieniinmano",name="Tieni in Mano",version="0.1.0",clientSideOnly=true)
public final class TieniInMano{
 public static Config config;
 @EventHandler public void init(FMLInitializationEvent e){config=Config.carica();Minecraft mc=Minecraft.getMinecraft();mc.entityRenderer.itemRenderer=new ManoRenderer(mc);}
}
