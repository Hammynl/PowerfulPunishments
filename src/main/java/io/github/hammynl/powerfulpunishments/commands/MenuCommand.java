package io.github.hammynl.powerfulpunishments.commands;

import io.github.hammynl.powerfulpunishments.enums.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MenuCommand extends BaseCommand {

    public MenuCommand() {
        super("pfp", Permissions.MAIN_MENU.toString(), 0, 1, true);
    }

    @Override
    protected void handleCommand(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&m=====&r &c&lPunishment&6&lManager &e&m====="));
    }
}
