package src.DB_Visualizer;

import models.Corso;
import src.Query_Executer.DAOStructure.CorsiDAO;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;
import src.Query_Factory.QueryFactory_Imp;

import java.sql.ResultSet;
import java.util.List;

public class Corsi_Strategy implements Strategy {

    String query;
    QueryFactory_Imp QF = new QueryFactory_Imp();
    Query Qy;
    Object result;
    List<Corso> result_list;

    Execute_Query EQ = new Execute_Query();
    CorsiDAO CDAO = new CorsiDAO(EQ);

    @Override
    public List<Corso> execute(String type,int ID) {

        System.out.println("Executing Corsi query...");

        switch(type)
        {
            case "C":
                query = "SELECT corsi.nome , corsi.orario_inizio , corsi.partecipanti " +
                        "FROM partecipazione JOIN corsi ON partecipazione.idCorso = corsi.idcorsi " +
                        "GROUP BY corsi.idcorsi " +
                        "WHERE affiliazione.idUtente = " + ID ;

                Qy = QF.createQuery(query);
                result_list = CDAO.getAllCorsi(Qy);
                if(result != null)
                    return result_list;
                else {
                    System.out.println("Error :prelevato lista corsi nulla in strategy corsi ");
                    break;
                }

            case "P", "I":
                query = "SELECT * FROM corsi ";
                Qy = QF.createQuery(query);
                result_list = CDAO.getAllCorsi(Qy);
                if(result_list != null)
                    return result_list;
                else {
                    System.out.println("Error :prelevato lista corsi nulla in strategy corsi ");
                    break;
                }
        }


        return null;
    }
}