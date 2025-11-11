package dev.ajaretro.retroBedrockTotem;

// --- All the imports we need ---
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.geysermc.floodgate.api.FloodgateApi; // This is our Floodgate check!

import java.util.UUID;

// We implement "Listener" so Paper knows this class listens for events
public class PlayerDamageListener implements Listener {

    /**
     * This is our main event handler!
     * The "@EventHandler" tag tells Paper/Folia to run this method
     * whenever an EntityDamageEvent happens.
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerDamage(EntityDamageEvent event) {

        // --- Step 1: Is this a Player? ---
        // We only care about damage to players, not zombies or cows
        if (!(event.getEntity() instanceof Player)) {
            return; // Not a player, so we do nothing
        }

        Player player = (Player) event.getEntity();

        // --- Step 2: Is this damage fatal? ---
        // We check if the damage taken is more than or equal to their current health
        if ((player.getHealth() - event.getFinalDamage()) > 0) {
            return; // Damage isn't fatal, so we don't need to do anything
        }

        // --- Step 3: Are they a Bedrock Player? ---
        // This is our key feature! We use the Floodgate API.
        UUID playerUuid = player.getUniqueId();
        if (!FloodgateApi.getInstance().isFloodgatePlayer(playerUuid)) {
            return; // Not a Bedrock player, let the vanilla game handle it
        }

        // --- Step 4: Do they have a totem ANYWHERE? ---
        PlayerInventory inventory = player.getInventory();
        ItemStack totem = null;
        int totemSlot = -1;

        // We loop through the *entire* inventory (main slots + armor + offhand)
        // inventory.getSize() is the most reliable way to check all slots
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack item = inventory.getItem(i);
            if (item != null && item.getType() == Material.TOTEM_OF_UNDYING) {
                totem = item;
                totemSlot = i;
                break; // Found one! Stop looping.
            }
        }

        // --- Step 5: The Save! ---
        if (totem != null && totemSlot != -1) {
            // WE FOUND A TOTEM! TIME TO SAVE THEM!

            // 1. CANCEL THE DEATH!
            event.setCancelled(true);

            // 2. Consume the totem
            totem.setAmount(totem.getAmount() - 1);
            inventory.setItem(totemSlot, totem); // Put the (possibly empty) stack back

            // 3. Heal them and give effects (just like a real totem)
            // Set health to 1.0 (half a heart)
            player.setHealth(1.0);

            // Clear any bad effects (like Wither or Poison)
            player.removePotionEffect(PotionEffectType.POISON);
            player.removePotionEffect(PotionEffectType.WITHER);

            // Give them the "Totem Pop" effects
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 900, 1)); // 45 seconds of Regen II
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 1)); // 5 seconds of Absorption II
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 800, 0)); // 40 seconds of Fire Res

            // 4. Play the cool sound and particle effects!
            player.getWorld().playSound(player.getLocation(), Sound.ITEM_TOTEM_USE, 1.0f, 1.0f);
            player.getWorld().spawnParticle(Particle.TOTEM_OF_UNDYING, player.getLocation().add(0, 1, 0), 50, 0.5, 0.5, 0.5, 0.1);
        }
    }
}