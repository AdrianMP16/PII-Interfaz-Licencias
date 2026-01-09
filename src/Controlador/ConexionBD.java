package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://ukwsbe9qsn9b1cvo:gRuDpez80UqNtGXFFdZj@bjhreqgoaghtpvvmphmi-mysql.services.clever-cloud.com:3306/bjhreqgoaghtpvvmphmi";
    private static final String USER = "ukwsbe9qsn9b1cvo";
    private static final String PASS = "gRuDpez80UqNtGXFFdZj";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}


