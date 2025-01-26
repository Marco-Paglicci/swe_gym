package src.Query_Executer.DAOStructure;

import models.Client;
import models.Subscrition;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Executer.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        try {
            // Esegui la query usando Execute_Query e ottieni il ResultSet
            try (ResultSet rs = executeQuery.executeGet(query)) {
                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return utenti; // Ritorna una lista vuota
                }

                // Trasforma il ResultSet in una lista di oggetti Utente

                while (rs.next()) {
                    System.out.println("Processando utente..."); // Messaggio di debug

                    // Crea l'oggetto Subscription
                    Subscrition sb = new Subscrition(
                            rs.getBoolean("premium"),
                            rs.getDate("scadenza")
                    );
                    System.out.println("Subscription creata con successo");

                    // Crea l'oggetto Client e aggiungilo alla lista
                    Client utente = new Client(
                            rs.getInt("idUtenti"),
                            rs.getString("nome"),
                            rs.getString("cognome"),
                            sb
                    );
                    utenti.add(utente);
                    System.out.println("Utente aggiunto alla lista");
                }

                System.out.println("Trasformazione completata con successo");
            }

        } catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generico durante il recupero degli utenti:");
            e.printStackTrace();
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
        ResultSet rs ;
        Client utente = null;

        try {
            // Esegui la query usando Execute_Query
            rs = executeQuery.executeGet(query);
            // Esegui la query
            System.out.println("Query eseguita correttamente");

            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {
                Subscrition sb = new Subscrition(
                        rs.getBoolean("premium"),
                        rs.getDate("scadenza")
                );
                    utente  = new Client(
                        rs.getInt("idUtente"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        sb
                );
            }

            System.out.println("Trasformazione eseguita correttamente");

            return utente;
        } catch (Exception e) {
            System.err.println("Errore durante il recupero degli utenti:");
            e.printStackTrace();
        }
        return null;
    }
}
