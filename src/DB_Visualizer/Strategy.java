package src.DB_Visualizer;

import java.sql.ResultSet;

// Strategy Interface
public interface Strategy {
    Object execute(String type, int ID);
}