package src.Query_Executer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public abstract  class Database {
    // Metodo per ottenere una connessione al database
     public abstract Connection getConnection();

    // Metodo per eseguire query di tipo SELECT
    public ResultSet executeQuery(String query) {
        System.out.println("Eseguo executeQuery: " + query);
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
        System.out.println("Eseguo executeUpdate: " + query);
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(query);
            System.out.println("Righe modificate: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Errore SQL durante l'esecuzione di executeUpdate: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.err.println("Errore generico durante l'esecuzione di executeUpdate: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
