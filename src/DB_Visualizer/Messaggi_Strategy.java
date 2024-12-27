package DB_Visualizer;

import java.sql.ResultSet;

public class MessaggiStrategy implements Strategy {
    @Override
    public ResultSet execute(String query) {
        System.out.println("Executing Messaggi query...");
        return Execute.execute(QueryFactory.createQuery(query));
    }
}