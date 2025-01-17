package src.Query_Executer;

import java.sql.ResultSet;

public interface QueryExecutionStrategy {
    ResultSet executeGetQuery(String query);

    boolean executeModifyQuery(String query);
}
