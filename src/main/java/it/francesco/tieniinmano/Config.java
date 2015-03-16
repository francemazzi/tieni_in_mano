package it.francesco.tieniinmano;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import java.io.File;

public final class Config{
 private final boolean attivo;
 private final float intensita;
 private final boolean oscillazione;
 public Config(boolean attivo,float intensita,boolean oscillazione){this.attivo=attivo;this.intensita=intensita;this.oscillazione=oscillazione;}
 public boolean attivo(){return attivo;}
 public float intensita(){return intensita;}
 public boolean oscillazione(){return oscillazione;}
 public static Config carica(){Configuration cfg=new Configuration(new File(Loader.instance().getConfigDir(),"tieni_in_mano.cfg"));cfg.load();boolean attivo=cfg.getBoolean("attivo","generale",true,"Abilita o disabilita la mod.");float intensita=cfg.getFloat("intensita","generale",1.0F,0.0F,2.0F,"Forza dell'effetto.");boolean oscillazione=cfg.getBoolean("oscillazione","generale",true,"Movimento durante lo swing.");if(cfg.hasChanged())cfg.save();return new Config(attivo,intensita,oscillazione);}
}
