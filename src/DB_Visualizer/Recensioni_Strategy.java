package DB_Visualizer;

import Query_Factory.QueryFactory;

import java.sql.ResultSet;

public class RecensioniStrategy implements Strategy {
    @Override
    public ResultSet execute(String query) {
        System.out.println("Executing Recensioni query...");
        return Execute.execute(QueryFactory.createQuery(query));
        //TODO CREATE EXECUTE CLASS
    }
}