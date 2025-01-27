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


    public UtenteDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
    }


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


                    Subscrition sb = new Subscrition(
                            rs.getBoolean("premium"),
                            rs.getDate("scadenza")
                    );


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


    public Client getUtenteById(Query query) {
        Client utente = null;

        try {
            // Esegui la query usando Execute_Query
            try(ResultSet rs = executeQuery.executeGet(query))
            {
                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return utente; // Ritorna una lista vuota
                }
                // Esegui la query
                System.out.println("Query eseguita correttamente");

                // Trasforma il ResultSet in una lista di oggetti Utente
                if(rs.next()) {
                    Subscrition sb = new Subscrition(
                            rs.getBoolean("premium"),
                            rs.getDate("scadenza")
                    );
                    utente = new Client(
                            rs.getInt("idUtente"),
                            rs.getString("nome"),
                            rs.getString("cognome"),
                            sb
                    );
                }

                System.out.println("Trasformazione eseguita correttamente");

                return utente;
            }
        } catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generico durante il recupero degli utenti:");
            e.printStackTrace();
        }
        return null;
    }
}
