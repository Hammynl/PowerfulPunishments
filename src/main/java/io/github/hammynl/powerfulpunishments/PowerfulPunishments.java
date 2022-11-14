package io.github.hammynl.powerfulpunishments;

import io.github.hammynl.powerfulpunishments.commands.BanCommand;
import io.github.hammynl.powerfulpunishments.commands.BaseCommand;
import io.github.hammynl.powerfulpunishments.commands.MenuCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PowerfulPunishments extends JavaPlugin {

    private static PowerfulPunishments main;

    public static PowerfulPunishments getMain() {
        return main;
    }


    @Override
    public void onEnable() {
        main = this;
        new MenuCommand();
        new BanCommand();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Goodbye!");
    }
}
