package src.Query_Executer.DAOStructure;


import models.Corso;
import models.Employee;
import models.Message;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    private final Execute_Query executeQuery;


    public MessageDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
    }

    public List<Message> getAllMessagebyId(Query query) {
        List<Message> Message_list = new ArrayList<>();

        try {
            try(ResultSet rs = executeQuery.executeGet(query)) {
                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return Message_list; // Ritorna una lista vuota
                }
                // Trasforma il ResultSet in una lista di oggetti Utente
                while (rs.next()) {

                    Message M = new Message(
                            rs.getInt("mittente"),
                            rs.getInt("destinatario"),
                            rs.getString("messaggio")

                    );
                    Message_list.add(M);
                    System.out.println("Messaggio aggiunto alla lista");
                }
                System.out.println("Trasformazione completata con successo");
            }

        }catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generico durante il recupero degli Message:");
            e.printStackTrace();
        }

        return Message_list;
    }
}
