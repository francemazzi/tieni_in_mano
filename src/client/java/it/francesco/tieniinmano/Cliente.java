package it.francesco.tieniinmano;

import net.fabricmc.api.ClientModInitializer;

public final class Cliente implements ClientModInitializer{
 public static Config config;
 public void onInitializeClient(){config=Config.carica();}
}
