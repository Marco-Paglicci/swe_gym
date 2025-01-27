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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personal_TrainerDAO {

    private final Execute_Query executeQuery;


    public Personal_TrainerDAO(Execute_Query executeQuery) {
        this.executeQuery = executeQuery;
    }

    public List<Personal_Trainer> getAllPersonalTrainer(Query query) {
        List<Personal_Trainer> Personal_Trainer_list = new ArrayList<>();



        try {
            try(ResultSet rs = executeQuery.executeGet(query)) {
                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return Personal_Trainer_list; // Ritorna una lista vuota
                }
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
                    System.out.println("PT aggiunto alla lista");
                }
                System.out.println("Trasformazione completata con successo");
            }

        }catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generico durante il recupero dei PT:");
            e.printStackTrace();
        }

        return Personal_Trainer_list;
    }


    public Personal_Trainer getPersonal_TrainerById(Query query) {
        Personal_Trainer PT = null;

        try {
            try (ResultSet rs = executeQuery.executeGet(query)) {
                if (rs == null || rs.isClosed()) {
                    System.err.println("ERRORE: il ResultSet è nullo o chiuso!");
                    return PT; // Ritorna una lista vuota
                }
                System.out.println("Query eseguita correttamente");

                // Trasforma il ResultSet in una lista di oggetti Utente
                if(rs.next()) {

                    PT = new Personal_Trainer(
                            rs.getInt("idPersonal trainer"),
                            rs.getString("nome"),
                            rs.getString("cognome"),
                            rs.getInt("eta"),
                            rs.getString("descrizione"),
                            rs.getInt("valutazione")
                    );
                }
                System.out.println("Trasformazione eseguita correttamente");
                return PT;
            }
        } catch (SQLException e) {
            System.err.println("Errore durante l'esecuzione della query:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generico durante il recupero degli PT by id:");
            e.printStackTrace();
        }
        return null;
    }
}
