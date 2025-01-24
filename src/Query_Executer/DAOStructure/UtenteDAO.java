package src.Query_Executer.DAOStructure;

import models.Client;
import models.Subscrition;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Executer.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

    private final Execute_Query executeQuery;

    // Costruttore che riceve l'oggetto Execute_Query
    public UtenteDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
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


        try {
            // Esegui la query usando Execute_Query
            rs = executeQuery.Execute(1, query).getResultSet();
            // Esegui la query


            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {
                Subscrition sb = new Subscrition(
                        rs.getBoolean("premium"),
                        rs.getDate("scadenza")
                );
                Client utente = new Client(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        sb
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
    public Client getUtenteById(Query query) {
        ResultSet rs = null;
        Client utente = null;

        try {
            // Esegui la query usando Execute_Query
            rs = executeQuery.Execute(1, query).getResultSet();
            // Esegui la query


            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {
                Subscrition sb = new Subscrition(
                        rs.getBoolean("premium"),
                        rs.getDate("scadenza")
                );
                    utente  = new Client(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        sb
                );
            }
            return utente;
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

        return null;
    }
}
