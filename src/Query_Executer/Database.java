package src.Query_Executer;

import java.sql.ResultSet;

public abstract  class Database {
    public abstract ResultSet executeQuery(String query);
    public abstract boolean executeUpdate(String query);
}
