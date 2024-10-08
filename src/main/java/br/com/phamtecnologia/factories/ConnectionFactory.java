package br.com.phamtecnologia.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String HOST = "jdbc:postgresql://localhost:5432/bd_api_clientes";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {

        Class.forName(DRIVER);
        return DriverManager.getConnection(HOST, USER, PASSWORD);
    }

}
