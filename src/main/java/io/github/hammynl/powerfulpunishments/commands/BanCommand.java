package io.github.hammynl.powerfulpunishments.commands;

import org.bukkit.command.CommandSender;

public class BanCommand extends BaseCommand {

    public BanCommand() {
        super("ban", "pfp.ban", 0, 1, true);
    }

    @Override
    protected void handleCommand(CommandSender sender, String[] args) {
        sender.sendMessage("jij bent kkr dom kkr kind CBR NEUKTTT!!!!");
    }
}
