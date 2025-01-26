package src;

import src.Query_Executer.Database;
import src.Query_Executer.MySQL_DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    String version = "1.2";

    //todo implementare ACCESS
    public static void main(String[] args) {
        System.out.println("Inizio test.test della connessione al database...");

        // Istanzia il database
        Database db = new MySQL_DB();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Ottieni la connessione e crea uno Statement
            conn = db.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM utenti");

            // Leggi i risultati
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
            }

        } catch (Exception e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } finally {
            // Chiudi le risorse in ordine inverso
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.err.println("Errore durante la chiusura delle risorse:");
                e.printStackTrace();
            }
        }

        System.out.println("Test completato.");
    }
}
