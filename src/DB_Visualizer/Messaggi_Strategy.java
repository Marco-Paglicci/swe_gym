package src.DB_Visualizer;

import models.Corso;
import models.Message;
import src.Query_Executer.DAOStructure.MessageDAO;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;

import java.sql.ResultSet;
import java.util.List;

public class Messaggi_Strategy implements Strategy {

    String query;
    QueryFactory QF;
    Query Qy;
    Execute_Query EQ;
    MessageDAO MDAO;
    List<Message> result_list;

    @Override
    public List<Message> execute(String type,int ID) {

        System.out.println("Executing Messaggi query...");

        switch(type)
        {
            case "C":
                query = "SELECT * " +
                        "FROM messaggio pt_u" +
                        "WHERE messaggio pt_u.destinatario = " + ID;
                Qy = QF.createQuery(query);
                result_list = MDAO.getAllMessagebyId(Qy);
                if(result_list != null)
                    return result_list;
                else {
                    System.out.println("Error : message list nulla in get messaggi ");
                    break;
                }

            case "P":
                query = "SELECT * " +
                        "FROM messaggio u_pt" +
                        "WHERE messaggio u_pt.destinatario = " + ID;
                Qy = QF.createQuery(query);
                result_list = MDAO.getAllMessagebyId(Qy);
                if(result_list != null)
                    return result_list;
                else {
                    System.out.println("Error : message list nulla in get messaggi ");
                    break;
                }

            case "I":
                query = "SELECT * " +
                        "FROM messaggio p_u" +
                        "WHERE messaggio p_u.mittente = " + ID;
                Qy = QF.createQuery(query);
                result_list = MDAO.getAllMessagebyId(Qy);
                if(result_list != null)
                    return result_list;
                else {
                    System.out.println("Error : message list nulla in get messaggi ");
                    break;
                }
        }

        return null;
    }
}