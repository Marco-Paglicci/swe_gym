package src.DB_Visualizer;


import models.Corso;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;

import java.sql.ResultSet;
import java.util.List;

public class Recensioni_Strategy implements Strategy {

    String query;
    QueryFactory QF;
    Query Qy;
    Execute_Query EQ;
    ResultSet RS;
    List<String> result_list;

    @Override
    public List<String> execute(String type, int ID) {
        System.out.println("Executing Recensioni query...");

        switch (type) {
            case "C":
                query = "SELECT recensione.recensione " +
                        "FROM recensione " +
                        "WHERE recensione.idUtente = " + ID;
                Qy = QF.createQuery(query);
                RS = EQ.executeGet(Qy);
                try {
                    while (RS.next()) {
                        result_list.add(RS.getString("recensione"));
                    }
                } catch (Exception e) {
                    System.err.println("Errore durante il recupero degli Personal Trainer:");
                    e.printStackTrace();
                }
                if (result_list != null)
                    return result_list;
                else {
                    System.out.println("Error :prelevato lista corsi nulla in strategy corsi ");
                    break;
                }
            case "P":
                query = "SELECT recensione.recensione " +
                        "FROM recensione " +
                        "WHERE recensione.idPersonaltrainer = " + ID;
                Qy = QF.createQuery(query);
                RS = EQ.executeGet(Qy);
                try {
                    while (RS.next()) {
                        result_list.add(RS.getString("recensione"));
                    }
                } catch (Exception e) {
                    System.err.println("Errore durante il recupero degli Personal Trainer:");
                    e.printStackTrace();
                }
                if (result_list != null)
                    return result_list;
                else {
                    System.out.println("Error :prelevato lista corsi nulla in strategy corsi ");
                    break;
                }
            case "I":
                query = "SELECT recensione.recensione " +
                        "FROM recensione ";
                Qy = QF.createQuery(query);
                RS = EQ.executeGet(Qy);
                try {
                    while (RS.next()) {
                        result_list.add(RS.getString("recensione"));
                    }
                } catch (Exception e) {
                    System.err.println("Errore durante il recupero degli Personal Trainer:");
                    e.printStackTrace();
                }
                if (result_list != null)
                    return result_list;
                else {
                    System.out.println("Error :prelevato lista corsi nulla in strategy corsi ");
                    break;
                }

        }

        return null;
    }
}