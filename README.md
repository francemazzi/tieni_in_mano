# Tieni in Mano

Mod client-side per **Fabric** che rende gli oggetti tenuti in mano più naturali in prima persona: posizione, rotazione e movimento leggermente più fisici, con pose diverse per armi, blocchi, cibo e oggetti generici.

## Note sul progetto

Questo è un **vecchio progetto** ripreso in seguito. Il codice e la documentazione sono stati rivisti e ottimizzati con **Cursor** e **Claude Code**, mantenendo però l’**ambiente old school** originale (Java 8, struttura minimale, stile compatto del sorgente) per coerenza con la versione iniziale — non è un refactor moderno, ma un aggiornamento leggero di un mod già esistente.

## Requisiti

| Componente | Versione |
|---|---|
| Minecraft | 26.1.2 |
| Fabric Loader | ≥ 0.19.2 |
| Java | ≥ 8 |

## Installazione

1. Installa [Fabric Loader](https://fabricmc.net/use/) per Minecraft 26.1.2.
2. Scarica l'ultimo `.jar` dalla sezione [Releases](https://github.com/francemazzi/tieni_in_mano/releases) (oppure compila da sorgente, vedi sotto).
3. Copia il file in `.minecraft/mods/`.
4. Avvia il gioco: la mod è solo lato client e non richiede installazione sul server.

## Configurazione

Al primo avvio viene creato `config/tieni_in_mano.json`:

```json
{
  "attivo": true,
  "intensita": 1.0,
  "oscillazione": true,
  "manoSecondaria": true,
  "log": false
}
```

| Opzione | Descrizione |
|---|---|
| `attivo` | Abilita o disabilita la mod. |
| `intensita` | Forza dell'effetto (`0.0`–`2.0`). |
| `oscillazione` | Aggiunge un leggero movimento durante lo swing dell'oggetto. |
| `manoSecondaria` | Applica l'effetto anche alla mano secondaria. |
| `log` | Abilita log di debug. |

Modifica il file e riavvia Minecraft per applicare le modifiche.

### Oggetti esclusi

Per evitare conflitti con animazioni vanilla, la mod non modifica:

- arco, balestra, scudo, tridente
- mappa e mappa vuota
- oggetti con trasformazione braccio personalizzata

## Compilazione

```bash
./gradlew build
```

Il `.jar` compilato si trova in `build/libs/`.

Per testare in sviluppo:

```bash
./gradlew runClient
```

## Come funziona

La mod intercetta il rendering della mano in prima persona (`ItemInHandRenderer`) e applica trasformazioni al `PoseStack` in base al tipo di oggetto:

- **Armi e attrezzi** — inclinazione e offset più marcati
- **Blocchi** — leggera riduzione di scala e spostamento in avanti
- **Cibo e pozioni** — rotazione e posizione orientate al consumo
- **Altri oggetti** — pose generica più naturale
