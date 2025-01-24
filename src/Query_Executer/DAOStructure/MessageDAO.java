package src.Query_Executer.DAOStructure;


import models.Corso;
import models.Employee;
import models.Message;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    private final Execute_Query executeQuery;

    // Costruttore che riceve l'oggetto Execute_Query
    public MessageDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
    }

    /**
     * Ottieni una lista di tutti gli utenti dal database.
     *
     * @param query Oggetto Query con la stringa SQL.
     * @return Lista di oggetti Utente.
     */
    public List<Message> getAllMessagebyId(Query query) {
        List<Message> Message_list = new ArrayList<>();
        ResultSet rs = null;


        try {
            // Esegui la query usando Execute_Query
            rs = executeQuery.Execute(1, query).getResultSet();
            // Esegui la query


            // Trasforma il ResultSet in una lista di oggetti Utente
            while (rs.next()) {

                Message M = new Message(
                        rs.getInt("mittente"),
                        rs.getInt("destinatario"),
                        rs.getString("messaggio")

                );
                Message_list.add(M);
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

        return Message_list;
    }
}
