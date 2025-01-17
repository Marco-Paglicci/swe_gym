package src.Query_Executer;

import java.sql.ResultSet;

public class Query_Result {
    private ResultSet resultSet;
    private Boolean success;

    public Query_Result(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public  Query_Result(Boolean success) {
        this.success = success;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Boolean getSuccess() {
        return success;
    }
}
