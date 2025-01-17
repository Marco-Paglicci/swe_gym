package src.Query_Executer;



import src.Query_Factory.Query;

import java.sql.ResultSet;

public class Execute_Query {

    private Database DB;
    private QueryExecutionStrategy strategy;



    public Execute_Query(Database DB, QueryExecutionStrategy Strategy)
    {
        this.DB = DB;
        this.strategy = Strategy;
    }

    public Query_Result  Execute(int request, Query query) {
        switch (request) {
            case 1: // Modalità get
                return new Query_Result(executeGet(query));
            case 2: // Modalità modify
                return new Query_Result(executeModify(query));
            default:
                throw new IllegalArgumentException("Invalid request type");
        }
    }

    private ResultSet executeGet(Query query)
    {
        return strategy.executeGetQuery(query.getQuery());
    }

    private boolean executeModify(Query query) {
        return strategy.executeModifyQuery(query.getQuery());
    }
}
