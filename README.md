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

A lightweight plugin that gives Bedrock (Floodgate) players a custom buff: Totem of Undying activation from *anywhere* in their inventory!

</div>

---

### 🚀 A Custom Buff for Bedrock Players

On a typical server, Totems of Undying only save you if they're in your main-hand or off-hand.

**This plugin changes the rules.**

It's designed to give your Bedrock (Floodgate) players a special advantage, perfect for fast-paced PvP, anarchy servers, or any world where you want to add a unique buff.

### ✨ What This Plugin Does

**RetroBedrockTotem** actively monitors your Bedrock players for fatal damage. If a Bedrock player is about to die, the plugin instantly scans their *entire inventory* for a Totem of Undying.

If a totem is found anywhere:
1.  The fatal blow is **cancelled**.
2.  One totem is **consumed** from their inventory.
3.  The standard totem effects are **triggered** (sound, particles, Regeneration, Absorption).

This allows for more aggressive playstyles and gives your Bedrock community a powerful quality-of-life feature that makes them just a bit more resilient in a fight.

### ⚙️ How It Works (Technically)

This plugin is extremely lightweight and efficient.
* It listens to the `EntityDamageEvent`.
* It immediately checks if the damaged entity is a `Player`, if the damage is fatal, and (most importantly) if they are a **Bedrock player** via the Floodgate API.
* **If and only if** all those conditions are met, it iterates through the player's inventory to find a `TOTEM_OF_UNDYING`.
* The moment one is found, it cancels the event, consumes the item, and applies the effects.

This entire process is highly optimized to add zero lag to your server's combat.

### 📦 Requirements
* **Spigot will work but we don't prefer it**
* **Paper and Folia** (or a Paper-fork like Pufferfish)
* **[Floodgate](https://github.com/GeyserMC/Floodgate)**

### 💾 Installation

1.  Download the latest `.jar` from the [Releases](https://github.com/AJARETRO/RetroBedrockTotem/releases) page.
2.  Drop the `RetroBedrockTotem.jar` into your server's `/plugins` folder.
3.  Restart your server.

That's it! There are no commands or configs. It just works.
