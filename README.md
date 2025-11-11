<div align="center">

```
RRRRR   EEEEEEE TTTTTTT RRRRR    OOOOO
R    R  E         T     R    R  O     O
RRRRR   EEEEE     T     RRRRR   O     O
R   R   E         T     R   R   O     O
R    R  EEEEEEE   T     R    R   OOOOO

BBBBBB   EEEEEEE DDDDD   RRRRR    OOOOO   CCCCCC  K   K
B     B  E       D    D  R    R  O     O  C       K  K
BBBBBB   EEEEE   D    D  RRRRR   O     O  C       KKK
B     B  E       D    D  R   R   O     O  C       K  K
BBBBBB   EEEEEEE DDDDD   R    R   OOOOO   CCCCCC  K   K

TTTTTTT  OOOOO  TTTTTTT EEEEEEE M     M
  T     O     O   T     E       MM   MM
  T     O     O   T     EEEEE   M M M M
  T     O     O   T     E       M  M  M
  T      OOOOO    T     EEEEEEE M     M
```

**By AJARETRO**

A simple, lightweight plugin to improve the Bedrock (Floodgate) player experience by allowing totem activation from anywhere in their inventory.

</div>

---

### 🤔 What's the Problem?

On a vanilla Minecraft: Java Edition server, Totems of Undying only work if they are held in the main-hand or off-hand.

Bedrock Edition players are used to a different mechanic: **a totem works as long as it's *anywhere* in their inventory.** When a Bedrock player joins a Java server (using [Floodgate](https://github.com/GeyserMC/Floodgate)), they are suddenly forced to use the Java mechanic, which feels unnatural and often results in unfair deaths.

### ✨ What This Plugin Does

**RetroBedrockTotem** fixes this parity issue!

This plugin detects when a Floodgate (Bedrock) player is about to die. If they are, it quickly scans their *entire inventory* for a Totem of Undying.

If a totem is found, the plugin will:
1.  **Cancel** the killing blow.
2.  **Consume** one totem from their inventory.
3.  **Play** all the usual totem effects (sound, particles).
4.  **Grant** the Regeneration and Absorption effects, just like vanilla.

This restores the expected Bedrock-style behavior and makes your server feel like home for Bedrock players.

### ⚙️ How It Works (Technically)

This plugin is extremely lightweight and efficient.
* It listens to the `EntityDamageEvent`.
* It checks if the damaged entity is a `Player` and if the damage is a fatal blow.
* It then uses the **Floodgate API** to verify the player is a Bedrock user.
* **If and only if** all those conditions are met, it iterates through the player's inventory to find a `TOTEM_OF_UNDYING`.
* The moment one is found, it cancels the event, consumes the item, and applies the effects.

This process is highly optimized to add zero lag to your server.

### 📦 Requirements

* **Paper** (or a Paper-fork like Pufferfish)
* **[Floodgate](https://github.com/GeyserMC/Floodgate)**

### 💾 Installation

1.  Download the latest `.jar` from the [Releases](https://github.com/AJARETRO/RetroBedrockTotem/releases) page.
2.  Drop the `RetroBedrockTotem.jar` into your server's `/plugins` folder.
3.  Restart your server.

That's it! There are no commands or configs. It just works.
