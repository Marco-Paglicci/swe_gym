package src.DB_Modify;

import models.Client;
import models.Corso;
import models.Message;
import models.Personal_Trainer;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;
import src.Query_Factory.QueryFactory_Imp;

public class Modify_Controller {
    boolean result = false;

    String query;
    QueryFactory_Imp QF = new QueryFactory_Imp();
    Query Qy;

    Execute_Query EQ = new Execute_Query();

    /*-----------------------QUERY DI MODIFICA----------------------------------*/


    public boolean modifica_informazioni(int ID, String nome, String cognome, String type) {
        System.out.println("caricamento informazioni");

        switch (type) {
            case "C":

                query = "UPDATE utenti" +
                        "SET Nome = '" + nome + "', Cognome = '" + cognome +
                        "' WHERE idUtenti = " + ID;
                break;

            case "P":

                query = "UPDATE personal_trainer" +
                        "SET nome = '" + nome + "', cognome = '" + cognome +
                        "' WHERE idPT = " + ID;
                break;


            case "I":

                query = "UPDATE personale" +
                        "SET nome = '" + nome + "', cognome = '" + cognome +
                        "' WHERE idpersonale = " + ID;
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

    public boolean modifica_partecipazione(int ID,Corso C,String type)
    {

        if(type.equals("C"))
        {
            query = "DELETE FROM partecipazione " +
                    "WHERE idUtente = " + ID + " AND idCorso = " + C.getId();
            Qy = QF.createQuery(query);
            result = EQ.executeModify(Qy);
            if (result) {
                return result;
            } else

                System.out.println("errore update Query");
            return false;
        }else
        {
            System.out.println("Non puoi fare questa operazione");
            return false;
        }
    }

    public boolean modifica_affiliazione(int ID,Personal_Trainer PT,String type)
    {

        if(type.equals("C"))
        {
            query = "DELETE FROM affiliazione " +
                    "WHERE idUtente = " + ID + " AND idPersonaltrainer = " + PT.getID();
            Qy = QF.createQuery(query);
            result = EQ.executeModify(Qy);
            if (result) {
                return result;
            } else

                System.out.println("errore update Query");
            return false;
        }else
        {
            System.out.println("Non puoi fare questa operazione");
            return false;
        }
    }







}
