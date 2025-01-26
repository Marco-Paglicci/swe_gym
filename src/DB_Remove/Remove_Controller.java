package src.DB_Remove;

import models.Client;
import models.Corso;
import models.Message;
import models.Personal_Trainer;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;
import src.Query_Factory.QueryFactory_Imp;

public class Remove_Controller
{
    boolean result = false;

    String query;
    QueryFactory_Imp QF = new QueryFactory_Imp();
    Query Qy;

    Execute_Query EQ = new Execute_Query();

    /*----------------------------------QUERY FOR REMOVE------------------------------*/

    public boolean remove_cliente(int ID, Client C, String type) {
        System.out.println("removing client");

        if(type.equals("I")) {
            query = "DELETE FROM utenti " +
                    "WHERE idUtenti = " + C.getID();


            Qy = QF.createQuery(query);
            result = EQ.executeModify(Qy);
            if (result) {
                return result;
            } else

                System.out.println("errore update Query");
            return false;
        }else {
            return false;
        }
    }


    public boolean remove_pt(int ID,Personal_Trainer PT, String type)
    {
        if(type.equals("I"))
        {
            System.out.println("removing PT " + PT.getNome() + "  " + PT.getCognome());

            query = "DELETE FROM persnal_trainer " +
                    "WHERE idPersonaltrainer = " + PT.getID() ;
            Qy = QF.createQuery(query);
            result = EQ.executeModify(Qy);
            if (result) {
                return result;
            } else

                System.out.println("errore update Query");
            return false;
        }else {
            return false;
        }

    }

    public boolean remove_corsi(int ID,Corso C,String type)
    {
        if(type.equals("I"))
        {
            System.out.println("removing PT " + C.getNome() + "  ");

            query = "DELETE FROM corsi " +
                    "WHERE idCorsi = " + C.getId() ;
            Qy = QF.createQuery(query);
            result = EQ.executeModify(Qy);
            if (result) {
                return result;
            } else

                System.out.println("errore update Query");
            return false;
        }else {
            return false;
        }
    }
    //todo ma orario non lo usi nemmeno nella query
    public boolean remove_appuntamento(int ID,int id_,/*String orario,*/String type)
    {
        switch (type) {
            case "C":

                query = "DELETE FROM appuntamento " +
                        "WHERE idUtente = " + ID + "AND idPersonaltrainer =" + id_;
                break;

            case "P":

                query = "DELETE FROM appuntamento " +
                        "WHERE idUtente = " + id_ + "AND idPersonaltrainer =" + ID;
                break;
        }
        Qy = QF.createQuery(query);
        result = EQ.executeModify(Qy);
        if (result) {
            return result;
        } else

            System.out.println("errore update Query");
        return false;
    }
}
