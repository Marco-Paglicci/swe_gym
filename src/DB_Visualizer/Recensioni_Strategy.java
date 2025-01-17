package src.DB_Visualizer;


import src.Query_Executer.Execute_Query;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;

import java.sql.ResultSet;

public class Recensioni_Strategy implements Strategy {

    String query;
    QueryFactory QF;
    Query Qy;
    Execute_Query EQ;
    ResultSet RS;

    @Override
    public ResultSet execute(int ID) {
        System.out.println("Executing Recensioni query...");
        query = "SELECT " +
                "* FROM Recensioni " +
                "WHERE Recensioni.personaltrainer = " + ID ;
        Qy = QF.createQuery(query);
        Object result = EQ.Execute(1,Qy);
        if (result instanceof  ResultSet)
        {
            RS = (ResultSet) result;
        }else{
            System.out.println("Error : Get Query Give out boolean value ");

        }
        return RS;
    }
}