package io.github.hammynl.powerfulpunishments.enums;

import org.bukkit.ChatColor;

public enum Menu {

    MENU_MAIN("&c&lSelect punishment"),
    CATEGORY_BAN("&c&lBan"),
    BUTTON_BAN("&c&oBan"),
    BUTTON_TEMPBAN("&c&oTemporary ban"),
    CATEGORY_MUTE("&c&lMute"),
    BUTTON_MUTE("&c&oMute"),
    BUTTON_TEMPMUTE("&c&oTemporary mute"),
    CATEGORY_WARNINGS("&6&LWarnings"),
    BUTTON_KICK("&6&oKick"),
    BUTTON_WARN("&6&oWarn"),
    CATEGORY_CORRECTION("&a&lCorrections"),
    BUTTON_UNBAN("&a&oUnban"),
    BUTTON_UNMUTE("&a&oUnmute");

    private String menuText;

    Menu(String menuText) {
        this.menuText = menuText;
    }

    @Override
    public String toString() {
        return ChatColor.translateAlternateColorCodes('&', menuText);
    }

}
