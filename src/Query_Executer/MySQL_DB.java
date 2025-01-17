package src.Query_Executer;

import java.sql.ResultSet;

public class MySQL_DB extends Database
{

    @Override
    public ResultSet executeQuery(String query) {
        return null;
    }

    @Override
    public boolean executeUpdate(String query) {
        return false;
    }
}
