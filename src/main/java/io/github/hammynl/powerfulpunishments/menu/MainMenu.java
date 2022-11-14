package io.github.hammynl.powerfulpunishments.menu;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu {

    public ItemStack createItem(Material material, int amount, String nameInput, String ...lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nameInput);
        itemmeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemmeta);
        return item;
    }

    public void openInv(Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 9*3, "kkr dikke menu");
        inv.setItem(0, createItem(Material.ACACIA_BOAT, 1, "kkr dikke boot g", "gay", "nigger"));
        player.openInventory(inv);
    }

}

