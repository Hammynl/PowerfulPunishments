package io.github.hammynl.powerfulpunishments.listeners;

import io.github.hammynl.powerfulpunishments.enums.PunishmentType;
import io.github.hammynl.powerfulpunishments.model.PunishmentModel;
import io.github.hammynl.powerfulpunishments.utils.PunishmentUtil;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

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

        event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, model.reason.replace("\\n", "\n"));

    }
}
