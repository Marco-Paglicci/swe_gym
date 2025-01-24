package src.Query_Executer.DAOStructure;

import models.Client;
import src.Query_Factory.Query;
import src.Query_Executer.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

    private final Database database;

    // Costruttore per ricevere il database (o Execute_Query se preferisci)
    public UtenteDAO(Database database) {
        this.database = database;
    }

    /**
     * Ottieni una lista di tutti gli utenti dal database.
     *
     * @param query Oggetto Query con la stringa SQL.
     * @return Lista di oggetti Utente.
     */
    public List<Client> getAllUtenti(Query query) {
        List<Client> utenti = new ArrayList<>();
        ResultSet rs = null;


        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query.getQuery())) {

            // Esegui la query
            rs = statement.executeQuery();

            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {
                Client utente = new Client(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getDate("scadenza abbonamento"),
                        rs.getObject('')
                );
                utenti.add(utente);
            }

        } catch (Exception e) {
            System.err.println("Errore durante il recupero degli utenti:");
            e.printStackTrace();
        } finally {
            // Chiudi il ResultSet se aperto
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Errore durante la chiusura del ResultSet:");
                e.printStackTrace();
            }
        }

        return utenti;
    }

    /**
     * Ottieni un singolo utente in base all'ID.
     *
     * @param query Oggetto Query con la stringa SQL.
     * @return Oggetto Utente, o null se non trovato.
     */
    public Utente getUtenteById(Query query) {
        ResultSet rs = null;

        // Gestione delle risorse
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query.getQuery())) {

            // Esegui la query
            rs = statement.executeQuery();

            // Se il risultato contiene un record, crealo come Utente
            if (rs.next()) {
                return new Utente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("email")
                );
            }

        } catch (Exception e) {
            System.err.println("Errore durante il recupero dell'utente per ID:");
            e.printStackTrace();
        } finally {
            // Chiudi il ResultSet se aperto
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Errore durante la chiusura del ResultSet:");
                e.printStackTrace();
            }
        }

        return null;
    }
}
