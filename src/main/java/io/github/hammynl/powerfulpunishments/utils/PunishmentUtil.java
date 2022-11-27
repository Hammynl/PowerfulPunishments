package io.github.hammynl.powerfulpunishments.utils;

import io.github.hammynl.powerfulpunishments.enums.PunishmentType;
import io.github.hammynl.powerfulpunishments.model.PunishmentModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PunishmentUtil {

    private StorageUtil storageUtil = StorageUtil.getInstance();


    public List<PunishmentModel> getPunishmentOfType(UUID uuid, PunishmentType type) {
        List<PunishmentModel> punishmentList = new ArrayList<>();

        try {
            PreparedStatement statement = storageUtil.getConnection().prepareStatement("SELECT * FROM Punishments WHERE victim = ? AND type = ?");
            statement.setString(1, uuid.toString());
            statement.setString(2, type.toString());

            ResultSet resultSet = statement.executeQuery();



            while(resultSet.next())
            {
                PunishmentModel model = new PunishmentModel();

                model.id = resultSet.getInt("id");
                model.issuer = UUID.fromString(resultSet.getString("issuer"));
                model.victim = UUID.fromString(resultSet.getString("victim"));
                model.type = resultSet.getString("type");
                model.reason = resultSet.getString("reason");
                model.issuedTime = resultSet.getInt("issuedTime");
                model.duration = resultSet.getInt("duration");
                punishmentList.add(model);
            }


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return punishmentList;
    }

    public void createBanPunishment(UUID uuid) {

    }

}
