package src.DB_Visualizer;// Concrete Strategies

import src.Query_Executer.DAOStructure.UtenteDAO;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;

import java.sql.ResultSet;

public class Informazioni_Strategy implements Strategy {

    String query;
    QueryFactory QF;
    Query Qy;

    UtenteDAO UtenteDAO;
    ResultSet RS;

    Object result;
    @Override
    public Object execute(String type,int ID) {
        System.out.println("Executing Informazioni query...");
        switch(type)
        {
            case "C":
                query = "SELECT * FROM utente WHERE utenti.idUtenti= " + ID ;
                Qy = QF.createQuery(query);
                result = UtenteDAO.getUtenteById(Qy);
                if(result != null)
                return result;
                else
                {
                    System.out.println("Erroe , prelevato utente nullo , id errato");
                    break;
                }


            case "P":
                query = "SELECT * FROM  WHERE Cliente.id = " + ID ;
                Qy = QF.createQuery(query);
                result = EQ.Execute(1,Qy);
                if (result instanceof  ResultSet)
                {
                    RS = (ResultSet) result;
                }else{
                    System.out.println("Error : Get Query Give out boolean value ");

                }
                return RS;

            case "I":
        }


    }
}

