package src.Query_Executer;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;



public class MySQL_DB extends Database
{

    private static final String URL = "jdbc:mysql://localhost:3306/Palestra";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    @Override
    protected Connection getConnection() {
        try {
            System.out.println("Connesione eseguita");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

}
