package io.github.hammynl.powerfulpunishments.menu;


import io.github.hammynl.powerfulpunishments.enums.Menu;
import io.github.hammynl.powerfulpunishments.utils.StorageUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PunishMenu extends BaseMenu {

    private OfflinePlayer victim;
    private Player issuer;

    public PunishMenu(String victimName, Player issuer) {
        super(5, Menu.MENU_MAIN.toString());
        this.victim = Bukkit.getOfflinePlayer(victimName);
        this.issuer = issuer;
        setMenuItems();
    }


    @Override
    protected void setMenuItems() {
        Inventory inv = getInventory();

        inv.setItem(4, createItem(Material.SUNFLOWER, 1,
                ChatColor.translateAlternateColorCodes('&', "&c&l&o" + victim.getName()),
                ChatColor.translateAlternateColorCodes('&', "&fUUID"),
                ChatColor.translateAlternateColorCodes('&', "&7&o" + victim.getUniqueId().toString())));

        inv.setItem(10, createItem(Material.BARRIER, 1, Menu.CATEGORY_BAN.toString()));
        inv.setItem(19, createItem(Material.HOPPER, 1, Menu.BUTTON_BAN.toString()));
        inv.setItem(28, createItem(Material.HOPPER, 1, Menu.BUTTON_TEMPBAN.toString()));

        inv.setItem(12, createItem(Material.JUKEBOX, 1, Menu.CATEGORY_MUTE.toString()));
        inv.setItem(21, createItem(Material.HOPPER, 1, Menu.BUTTON_MUTE.toString()));
        inv.setItem(30, createItem(Material.HOPPER, 1, Menu.BUTTON_TEMPMUTE.toString()));

        inv.setItem(14, createItem(Material.OAK_DOOR, 1, Menu.CATEGORY_WARNINGS.toString()));
        inv.setItem(23, createItem(Material.HOPPER, 1, Menu.BUTTON_WARN.toString()));
        inv.setItem(32, createItem(Material.HOPPER, 1, Menu.BUTTON_KICK.toString()));

        inv.setItem(16, createItem(Material.FEATHER, 1, Menu.CATEGORY_CORRECTION.toString()));
        inv.setItem(25, createItem(Material.HOPPER, 1, Menu.BUTTON_UNBAN.toString()));
        inv.setItem(34, createItem(Material.HOPPER, 1, Menu.BUTTON_UNMUTE.toString()));

    }

    @Override
    public void handleClicks(InventoryClickEvent event) {
        if(event.getSlot() == 19)
        {
            StorageUtil.getInstance().executeQuery("");
        }
    }
}

