package src.Query_Executer;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public abstract  class Database {
    // Metodo per ottenere una connessione al database
     public abstract Connection getConnection();

    // Metodo per eseguire query di tipo SELECT
    public ResultSet executeQuery(String query) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            return stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante l'esecuzione della query", e);
        }
    }

    // Metodo per eseguire query di tipo INSERT, UPDATE, DELETE
    public boolean executeUpdate(String query) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(query) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
