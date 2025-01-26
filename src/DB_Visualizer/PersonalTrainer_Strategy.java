package src.DB_Visualizer;

import models.Corso;
import models.Personal_Trainer;
import src.Query_Executer.DAOStructure.Personal_TrainerDAO;
import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;
import src.Query_Factory.QueryFactory_Imp;

import java.sql.ResultSet;
import java.util.List;

public class PersonalTrainer_Strategy implements Strategy {

    String query;
    QueryFactory_Imp QF = new QueryFactory_Imp();
    Query Qy;

    Object result;
    List<Personal_Trainer> result_list;
    Execute_Query EQ = new Execute_Query();
    Personal_TrainerDAO PTDAO = new Personal_TrainerDAO(EQ);

    @Override
    public List<Personal_Trainer> execute(String type,int ID) {

        System.out.println("Executing PT query...");

        switch(type){

            case "C":
                query = "SELECT  personal_trainer.nome , personal_trainer.cognome , personal_trainer.eta, personal_trainer.descrizione , personal_trainer.valutazione" +
                        "FROM personal_trainer JOIN affiliazione ON personal_trainer.idPT = affiliazione.idPersonaltrainer" +
                        "GROUP BY personal_trainer.idPT" +
                        " WHERE affiliazione.idUtente= " + ID;
                Qy = QF.createQuery(query);
                result_list = PTDAO.getAllPersonalTrainer(Qy);
                if (result != null)
                    return result_list;
                else {
                    System.out.println("Erroe , PT nullo  , id errato");
                    break;
                }


            case "I":
                query = "SELECT * FROM personal_trainer ";

                Qy = QF.createQuery(query);
                result_list = PTDAO.getAllPersonalTrainer(Qy);
                if (result != null)
                    return result_list;
                else {
                    System.out.println("Erroe , PT nullo , id errato");
                    break;
                }


        }
        return null;
    }
}