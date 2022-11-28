package io.github.hammynl.powerfulpunishments;

import io.github.hammynl.powerfulpunishments.commands.PunishCommand;
import io.github.hammynl.powerfulpunishments.commands.MenuCommand;
import io.github.hammynl.powerfulpunishments.listeners.JoinListener;
import io.github.hammynl.powerfulpunishments.listeners.MenuListener;
import io.github.hammynl.powerfulpunishments.utils.DatabaseUtil;
import io.github.hammynl.powerfulpunishments.utils.StorageUtil;
import org.bukkit.Bukkit;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class PowerfulPunishments extends JavaPlugin {

    private static PowerfulPunishments main;

    public static PowerfulPunishments getMain() {
        return main;
    }


    @Override
    public void onEnable() {
        main = this;
        saveDefaultConfig();

        // Registering methods
        registerCommands();
        registerEvents();
        registerUtils();

    }



    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Goodbye!");
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    private void registerCommands() {
        new MenuCommand();
        new PunishCommand();
    }

    private void registerUtils() {
        StorageUtil.getInstance().setup(this);
        DatabaseUtil.getInstance().setup(this);
    }
}
