package src.DB_Visualizer;

import java.sql.ResultSet;

// Strategy Interface
public interface Strategy {
    ResultSet execute(int ID);
}