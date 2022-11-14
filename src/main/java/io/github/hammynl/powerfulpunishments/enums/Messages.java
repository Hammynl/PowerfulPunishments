package io.github.hammynl.powerfulpunishments.enums;

import org.bukkit.ChatColor;

public enum Messages {

    NO_PERMISSION("&cYou do not have permission to perform this command!"),
    NOT_PLAYER("&cYou must be a player to perform this command!");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
