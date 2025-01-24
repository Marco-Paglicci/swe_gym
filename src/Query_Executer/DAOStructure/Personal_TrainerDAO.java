package src.Query_Executer.DAOStructure;

import models.Client;
import models.Personal_Trainer;
import models.Subscrition;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Executer.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Personal_TrainerDAO {

    private final Execute_Query executeQuery;

    // Costruttore che riceve l'oggetto Execute_Query
    public Personal_TrainerDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
    }

    /**
     * Ottieni una lista di tutti gli utenti dal database.
     *
     * @param query Oggetto Query con la stringa SQL.
     * @return Lista di oggetti Utente.
     */
    public List<Personal_Trainer> getAllPersonalTrainer(Query query) {
        List<Personal_Trainer> Personal_Trainer_list = new ArrayList<>();
        ResultSet rs = null;


        try {
            // Esegui la query usando Execute_Query
            rs = executeQuery.Execute(1, query).getResultSet();
            // Esegui la query


            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {

                Personal_Trainer PT = new Personal_Trainer(
                        rs.getInt("idPersonal trainer"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getInt("eta"),
                        rs.getString("descrizione"),
                        rs.getInt("valutazione")
                );
                Personal_Trainer_list.add(PT);
            }

        } catch (Exception e) {
            System.err.println("Errore durante il recupero degli Personal Trainer:");
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

        return Personal_Trainer_list;
    }

    /**
     * Ottieni un singolo utente in base all'ID.
     *
     * @param query Oggetto Query con la stringa SQL.
     * @return Oggetto Utente, o null se non trovato.
     */
    public Personal_Trainer getPersonal_TrainerById(Query query) {
        ResultSet rs = null;
        Personal_Trainer PT = null;

        try {
            // Esegui la query usando Execute_Query
            rs = executeQuery.Execute(1, query).getResultSet();
            // Esegui la query


            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {

                 PT = new Personal_Trainer(
                        rs.getInt("idPersonal trainer"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getInt("eta"),
                        rs.getString("descrizione"),
                        rs.getInt("valutazione")
                );
            }
            return PT;
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
