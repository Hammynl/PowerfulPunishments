package io.github.hammynl.powerfulpunishments.commands;

import io.github.hammynl.powerfulpunishments.enums.Messages;
import io.github.hammynl.powerfulpunishments.enums.Permissions;
import io.github.hammynl.powerfulpunishments.menu.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand extends BaseCommand {

    public MenuCommand() {
        super("pfp", "pfp.menu", 0, 1, true);
    }

    @Override
    protected void handleCommand(CommandSender sender, String[] args) {
        new MainMenu().openInv((Player) sender);
    }
}
