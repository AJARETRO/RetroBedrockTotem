package dev.ajaretro.retroBedrockTotem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class RetroBedrockTotem extends JavaPlugin {

    private final String consolePrefix = ChatColor.BOLD + "[" + ChatColor.DARK_RED + "AJA_RETRO" + ChatColor.GRAY + "/" + ChatColor.DARK_AQUA + "BedrockTotem" + ChatColor.WHITE + ChatColor.BOLD + "] " + ChatColor.RESET;
    @Override
    public void onEnable() {
        // This is the most important line!
        // We're creating a new listener class (which we'll make next)
        // and telling the server to start paying attention to it.

        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "==================================================");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(consolePrefix + ChatColor.GREEN + "Enabling " + ChatColor.AQUA + "RetroBedrockTotem" + ChatColor.GREEN + " v" + getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(consolePrefix + ChatColor.GRAY + "Created by: " + ChatColor.WHITE + getDescription().getAuthors().get(0));
        Bukkit.getConsoleSender().sendMessage(consolePrefix + ChatColor.GRAY + "Website: " + ChatColor.WHITE + getDescription().getWebsite());
        getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(consolePrefix + ChatColor.GREEN + "Plugin is loaded and ready to save some Bedrock players!");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "==================================================");



    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(consolePrefix + ChatColor.RED + "Plugin has been disabled.");
    }
}