package src.DB_Visualizer;

import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;
import src.Query_Factory.QueryFactory_Imp;

import java.sql.ResultSet;
import java.util.List;

public class Appuntamento_Strategy implements Strategy {

    String query;
    QueryFactory_Imp QF = new QueryFactory_Imp();
    Query Qy;
    Execute_Query EQ = new Execute_Query();
    ResultSet RS;

    List<String> result_list;

    @Override
    public List<String> execute(String type,int ID) {
        System.out.println("Executing Appuntamento query...");



        switch (type) {
            case "C":
                query = "SELECT appuntameto.orario " +
                        " FROM appuntamento " +
                        " WHERE appuntamento.idUtente = " + ID;
                Qy = QF.createQuery(query);
                RS = EQ.executeGet(Qy);
                try {
                    while (RS.next()) {
                        result_list.add(RS.getString("orario"));
                    }
                } catch (Exception e) {
                    System.err.println("Errore durante il recupero degli appuntamenti:");
                    e.printStackTrace();
                }
                if (result_list != null)
                    return result_list;
                else {
                    System.out.println("Error :appuntamenti ");
                    break;
                }
            case "P":
                query = "SELECT appuntameto.orario " +
                        "FROM appuntamento " +
                        "WHERE appuntamento.idPersonaltrainer = " + ID;
                Qy = QF.createQuery(query);
                RS = EQ.executeGet(Qy);
                try {
                    while (RS.next()) {
                        result_list.add(RS.getString("orario"));
                    }
                } catch (Exception e) {
                    System.err.println("Errore durante il recupero degli appuntamenti:");
                    e.printStackTrace();
                }
                if (result_list != null)
                    return result_list;
                else {
                    System.out.println("Error appuntamenti ");
                    break;
                }
        }



        return null;
    }
}
