package src.Query_Executer.DAOStructure;



import models.Corso;
import models.Employee;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorsiDAO {

    private final Execute_Query executeQuery;


    public CorsiDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
    }


    public List<Corso> getAllCorsi(Query query) {
        List<Corso> Corso_list = new ArrayList<>();

        try {
            try (ResultSet rs = executeQuery.executeGet(query)) {
                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return Corso_list; // Ritorna una lista vuota
                }

                // Trasforma il ResultSet in una lista di oggetti Utente

                while (rs.next()) {

                    Corso C = new Corso(
                            rs.getInt("idcorsi"),
                            rs.getString("nome"),
                            rs.getTime("orario_inizio"),
                            rs.getInt("partecipanti")

                    );
                    Corso_list.add(C);
                    System.out.println("Corso aggiunto alla lista");
                }
                System.out.println("Trasformazione completata con successo");
            }
            } catch (SQLException e) {
                System.err.println("Errore durante l'esecuzione della query:");
                e.printStackTrace();
            }  catch (Exception e) {
            System.err.println("Errore generico durante il recupero degli Corsi:");
            e.printStackTrace();
        }

            return Corso_list;
        }



    public Corso getCorsoById(Query query) {
        Corso C  = null;

        try {
            try (ResultSet rs = executeQuery.executeGet(query)) {

                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return C; // Ritorna una lista vuota
                }

                System.out.println("Query eseguita correttamente");

                // Trasforma il ResultSet in una lista di oggetti Utente
                 if(rs.next()) {

                    C = new Corso(
                            rs.getInt("idcorsi"),
                            rs.getString("nome"),
                            rs.getTime("orario_inizio"),
                            rs.getInt("partecipanti")
                    );
                }

                System.out.println("Trasformazione eseguita correttamente");
                return C;
            }

        } catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generico durante il recupero degli corsi:");
            e.printStackTrace();
        }
        return null;
    }
}
