package io.github.hammynl.powerfulpunishments.enums;

public enum Query {
    CREATE_PUNISHMENT_TABLE(
            "CREATE TABLE IF NOT EXISTS Punishments (" +
                    "[id]           INTEGER                 PRIMARY KEY        AUTOINCREMENT," +
                    "[victim]       VARCHAR(36)             NOT NULL," +
                    "[issuer]       VARCHAR(36)," +
                    "[type]         VARCHAR(10)," +
                    "[reason]       VARCHAR(100)," +
                    "[issuedTime]    INTEGER," +
                    "[duration]      INTEGER" +
                    ");"
    );

    private String query;

    Query(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return query;
    }
}
