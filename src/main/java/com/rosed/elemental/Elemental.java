package com.rosed.elemental;

import com.rosed.elemental.Commands.SummonTrader;
import com.rosed.elemental.Listeners.ElementActivateEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.Lamp;
import revxrsal.commands.bukkit.BukkitLamp;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

public final class Elemental extends JavaPlugin {

    private static Elemental instance;
    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;
        playerManager = new PlayerManager();
        registerEvents();
        registerCommands();

        // add all players to PlayerManager reading from JSON
        // (!) if player is not in json, add them as new player with no element

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * Registers all commands
     */
    private void registerCommands() {
        Lamp<BukkitCommandActor> lamp = BukkitLamp.builder(this).build();
        lamp.register(new SummonTrader());
    }

    /**
     * Registers all events
     */
    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new ElementActivateEvent(), this);
    }

    public static Elemental getInstance() { return instance; }
}
