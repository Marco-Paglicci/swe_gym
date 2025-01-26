package src.Query_Executer;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;



public class MySQL_DB extends Database
{

    private static final String URL = "jdbc:mysql://localhost:3306/palestradb";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    @Override
    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connesso al database!");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore di connessione al database", e);
        }
    }




}
