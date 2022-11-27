package io.github.hammynl.powerfulpunishments.enums;

public enum Permissions {

    MAIN_MENU("pfp.menu"),
    PUNISH("pfp.punish");

    private String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return permission;
    }
}
