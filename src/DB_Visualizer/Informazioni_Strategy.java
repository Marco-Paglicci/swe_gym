package src.DB_Visualizer;// Concrete Strategies

import src.Query_Executer.DAOStructure.EmployeeDAO;
import src.Query_Executer.DAOStructure.Personal_TrainerDAO;
import src.Query_Executer.DAOStructure.UtenteDAO;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;
import src.Query_Factory.QueryFactory_Imp;

import java.sql.ResultSet;
import java.util.List;

public class Informazioni_Strategy implements Strategy {

    String query;
    QueryFactory_Imp QF = new QueryFactory_Imp();
    Query Qy;

    Execute_Query EQ = new Execute_Query();

    UtenteDAO UtenteDAO = new UtenteDAO(EQ);
    Personal_TrainerDAO PTDAO = new Personal_TrainerDAO(EQ);

    EmployeeDAO PDAO = new EmployeeDAO(EQ);


    Object result;
    List<Object> result_list;

    @Override
    public List<Object> execute(String type, int ID) {
        System.out.println("Executing Informazioni query...");
        switch (type) {
            case "C":
                query = "SELECT * FROM utenti WHERE utenti.idUtenti= " + ID;
                Qy = QF.createQuery(query);
                result = UtenteDAO.getUtenteById(Qy);
                result_list.add(result);
                if (result != null)
                    return result_list;
                else {
                    System.out.println("Erroe , prelevato utente nullo , id errato");
                    break;
                }


            case "P":
                query = "SELECT * FROM  personal_trainer WHERE personal_trainer.idPersonaltrainer = " + ID;
                Qy = QF.createQuery(query);
                result = PTDAO.getPersonal_TrainerById(Qy);
                result_list.add(result);
                if (result != null)
                    return result_list;
                else {
                    System.out.println("Error : Get Query Give out boolean value ");
                    break;
                }


            case "I":
                query = "SELECT * FROM personale  WHERE personale.idpersonale = " + ID;
                Qy = QF.createQuery(query);
                result = PDAO.getEmployeeById(Qy);
                result_list.add(result);
                if (result != null)
                    return result_list;
                else {
                    System.out.println("Error : Get Query Give out boolean value ");
                    break;
                }
        }


        return null;
    }
}



