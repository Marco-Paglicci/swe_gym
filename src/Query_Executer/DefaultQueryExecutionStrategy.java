package src.Query_Executer;

import java.sql.ResultSet;

public class DefaultQueryExecutionStrategy implements QueryExecutionStrategy {

    private Database DB;

    public DefaultQueryExecutionStrategy(Database db)
    {
        this.DB = db;
    }

    @Override
    public ResultSet executeGetQuery(String query)
    {
        System.out.println("Executing  query " + query);
        return DB.executeQuery(query);
    }

    @Override
    public boolean executeModifyQuery(String query)
    {
        System.out.println("Executing modifing query " + query);
        return DB.executeUpdate(query);
    }
}
