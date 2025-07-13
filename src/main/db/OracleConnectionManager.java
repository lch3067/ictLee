package main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import main.util.XmlConfig;

public class OracleConnectionManager {
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Oracle JDBC Driver load failed", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        XmlConfig cfg = XmlConfig.load();
        return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
    }
}