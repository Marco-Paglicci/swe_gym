package DB_Visualizer;

import java.sql.ResultSet;

public class DB_Visualizer {
    private String query;
    private ResultSet result;
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void generateExecute() {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        result = strategy.execute(query);
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ResultSet getResult() {
        return result;
    }
}
