package io.github.hammynl.powerfulpunishments.listeners;

import io.github.hammynl.powerfulpunishments.enums.PunishmentType;
import io.github.hammynl.powerfulpunishments.model.PunishmentModel;
import io.github.hammynl.powerfulpunishments.utils.PunishmentUtil;
import io.github.hammynl.powerfulpunishments.utils.StorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JoinListener implements Listener {

    private final PunishmentUtil punishmentUtil = new PunishmentUtil();


    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent event) {
        UUID uuid = event.getUniqueId();
        List<PunishmentModel> bans = punishmentUtil.getPunishmentOfType(uuid, PunishmentType.BAN);

        PunishmentModel model = bans.stream().filter(PunishmentModel::isActive).findFirst().orElse(null);

        if(model == null)
        {
            return;
        }
        FileConfiguration file = StorageUtil.getInstance().getLanguage();

        StringBuilder banMessage = new StringBuilder();
        for (String line : file.getStringList("ban-message")) {
            banMessage.append(line).append("\n");
        }

        event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', banMessage.toString()
                .replace("\\n", "\n")
                .replace("[reason]", model.reason)
                .replace("[issuer]", Bukkit.getOfflinePlayer(model.issuer).getName())
                .replace("[duration]", model.duration + "")

        ));


    }
}
