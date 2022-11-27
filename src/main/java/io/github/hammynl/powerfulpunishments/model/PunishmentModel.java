package io.github.hammynl.powerfulpunishments.model;

import java.util.Date;
import java.util.UUID;

public class PunishmentModel {

    public int id;
    public UUID victim;
    public UUID issuer;
    public String type;
    public String reason;
    public int issuedTime;
    public int duration;

    public boolean isActive() {
        if(duration == 0) return true;

        long unixTime = System.currentTimeMillis() / 1000L;
        long expiredTime = issuedTime + duration;

        return expiredTime > unixTime;

    }

}
