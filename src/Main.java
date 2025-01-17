package src;

import src.Query_Executer.Database;
import src.Query_Executer.MySQL_DB;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {


        //todo remove testing for database
        Database db = new MySQL_DB();

        // Esempio di query SELECT
        ResultSet rs = db.executeQuery("SELECT * FROM utenti");
        try {
            while (rs != null && rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    }
