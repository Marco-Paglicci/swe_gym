package src.DB_Visualizer;

import models.Client;
import models.Corso;
import src.Query_Executer.DAOStructure.CorsiDAO;
import src.Query_Executer.DAOStructure.UtenteDAO;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;
import src.Query_Factory.QueryFactory_Imp;

import java.util.List;

public class Clienti_Strategy implements Strategy{


    String query;
    QueryFactory_Imp QF = new QueryFactory_Imp();
    Query Qy;
    List<Client> result_list;

    Execute_Query EQ = new Execute_Query();
    UtenteDAO UDAO = new UtenteDAO(EQ);

    @Override
    public List<Client> execute(String type, int ID) {

        switch(type)
        {
            case "P":
                query = "SELECT utenti.Nome,utenti.Cognome " +
                        "FROM utenti  LEFT JOIN affiliazione ON  utenti.idUtenti = affiliazione.idUtente" +
                        "WHERE affiliazione.idUtente = " + ID;
                Qy = QF.createQuery(query);
                result_list = UDAO.getAllUtenti(Qy);
                if(result_list != null)
                    return result_list;
                else {
                    System.out.println("Error :prelevato lista corsi nulla in strategy corsi ");
                    break;
                }


            case "I":
                query = "SELECT *" +
                        "FROM utenti ";
                Qy = QF.createQuery(query);
                result_list = UDAO.getAllUtenti(Qy);
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
