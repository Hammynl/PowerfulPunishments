package io.github.hammynl.powerfulpunishments.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseMenu implements InventoryHolder {

    private Inventory inventory;

    public ItemStack createItem(Material material, int amount, String nameInput) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nameInput);
        item.setItemMeta(itemmeta);
        return item;
    }

    public ItemStack createItem(Material material, int amount, String nameInput, String ...lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nameInput);

        ArrayList<String> colorCodedLore = new ArrayList<>();
        for (String line: lore
             ) {
            colorCodedLore.add(ChatColor.translateAlternateColorCodes('&', line));
        }

        itemmeta.setLore(colorCodedLore);
        item.setItemMeta(itemmeta);
        return item;
    }

    public BaseMenu(int rows, String title) {

        inventory = Bukkit.createInventory(this, 9*rows, title);
        for(int i = 0; i<9*rows; i++) {
            inventory.setItem(i, createItem(Material.BLACK_STAINED_GLASS_PANE, 1, " "));
        }

        for(int i = 0; i<9; i++) {
                inventory.setItem(i, createItem(Material.RED_STAINED_GLASS_PANE, 1, " "));
        }

        for(int i = (9*rows) -1; i > 9*(rows-1) -1; i--) {
            inventory.setItem(i, createItem(Material.RED_STAINED_GLASS_PANE, 1, " "));
        }

    }

    protected abstract void setMenuItems();

    public abstract void handleClicks(InventoryClickEvent event);

    public void openInventory(Player player)
    {
        player.openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
