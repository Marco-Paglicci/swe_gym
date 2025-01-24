package src.Query_Executer.DAOStructure;



import models.Corso;
import models.Employee;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CorsiDAO {

    private final Execute_Query executeQuery;

    // Costruttore che riceve l'oggetto Execute_Query
    public CorsiDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
    }

    /**
     * Ottieni una lista di tutti gli utenti dal database.
     *
     * @param query Oggetto Query con la stringa SQL.
     * @return Lista di oggetti Utente.
     */
    public List<Corso> getAllCorsi(Query query) {
        List<Corso> Corso_list = new ArrayList<>();
        ResultSet rs = null;


        try {
            // Esegui la query usando Execute_Query
            rs = executeQuery.Execute(1, query).getResultSet();
            // Esegui la query


            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {

                Corso C = new Corso(
                        rs.getInt("idcorsi"),
                        rs.getString("nome"),
                        rs.getTime("orario_inizio"),
                        rs.getInt("partecipanti")

                );
                Corso_list.add(C);
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

        return Corso_list;
    }

    /**
     * Ottieni un singolo utente in base all'ID.
     *
     * @param query Oggetto Query con la stringa SQL.
     * @return Oggetto Utente, o null se non trovato.
     */
    public Corso getCorsoById(Query query) {
        ResultSet rs = null;
        Corso C  = null;

        try {
            // Esegui la query usando Execute_Query
            rs = executeQuery.Execute(1, query).getResultSet();
            // Esegui la query


            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {

                C = new Corso(
                        rs.getInt("idcorsi"),
                        rs.getString("nome"),
                        rs.getTime("orario_inizio"),
                        rs.getInt("partecipanti")
                );
            }
            return C;
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
