package net.meziyani.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by yanim on 2017-07-19.
 */
public class Database {

    private String name;
    private MDatabase mdb;
    private Connection connection;
    private String url_base = "jdbc:mysql://", host, user, password;


    public Database(String name, MDatabase mdb){
        this.name = name;
        this.host = mdb.getConfig().getString("host");
        this.user = mdb.getConfig().getString("credentials.user");
        this.password = mdb.getConfig().getString("credentials.password");
    }

    public boolean connect(){
        try {
            this.connection = DriverManager.getConnection(url_base + host + name, user, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void execute(String query) {
        connect();
        PreparedStatement sts;
        try {
            sts = connection.prepareStatement(query);
            sts.executeUpdate();
            sts.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        disconnect();
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        try {
            if (connection == null || connection.isClosed()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
