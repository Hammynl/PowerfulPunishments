package io.github.hammynl.powerfulpunishments.listeners;

import io.github.hammynl.powerfulpunishments.menu.BaseMenu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryItemClick(InventoryClickEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();
        if(holder instanceof BaseMenu) {
            event.setCancelled(true);
            BaseMenu menu = (BaseMenu) holder;
            menu.handleClicks(event);
        }
    }
}
