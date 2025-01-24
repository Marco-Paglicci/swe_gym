package src.DB_Visualizer;

import java.sql.ResultSet;
import java.util.List;

// Strategy Interface
public interface Strategy {
    List execute(String type, int ID);
}