package it.francesco.tieniinmano;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Config {
 static final Gson G = new GsonBuilder().setPrettyPrinting().create();
 static final Config BASE = new Config(true, 1, true, true, false);
 static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("tieni_in_mano.json");

 private final boolean attivo;
 private final float intensita;
 private final boolean oscillazione;
 private final boolean manoSecondaria;
 private final boolean log;

 public Config(boolean attivo, float intensita, boolean oscillazione, boolean manoSecondaria, boolean log) {
  this.attivo = attivo;
  this.intensita = intensita;
  this.oscillazione = oscillazione;
  this.manoSecondaria = manoSecondaria;
  this.log = log;
 }

 public boolean attivo() { return attivo; }
 public float intensita() { return intensita; }
 public boolean oscillazione() { return oscillazione; }
 public boolean manoSecondaria() { return manoSecondaria; }
 public boolean log() { return log; }

 public static Config carica() {
  try {
   if (Files.notExists(FILE)) return salva(BASE);
   try (Reader r = Files.newBufferedReader(FILE)) {
    Config c = G.fromJson(r, Config.class);
    return c == null ? salva(BASE) : c.sana();
   }
  } catch (Exception e) {
   return salva(BASE);
  }
 }

 Config sana() {
  return new Config(attivo, Math.max(0, Math.min(2, intensita)), oscillazione, manoSecondaria, log);
 }

 static Config salva(Config c) {
  try {
   Files.createDirectories(FILE.getParent());
   try (Writer w = Files.newBufferedWriter(FILE)) {
    G.toJson(c, w);
   }
  } catch (Exception e) { }
  return c;
 }
}
