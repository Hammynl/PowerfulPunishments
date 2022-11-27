package io.github.hammynl.powerfulpunishments.commands;

import io.github.hammynl.powerfulpunishments.enums.Permissions;
import io.github.hammynl.powerfulpunishments.menu.PunishMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCommand extends BaseCommand {

    public PunishCommand() {

        super("punish", Permissions.PUNISH.toString(), 1, 1, true);
    }

    @Override
    protected void handleCommand(CommandSender sender, String[] args) {
        new PunishMenu(args[0], (Player) sender).openInventory((Player) sender);
    }
}
