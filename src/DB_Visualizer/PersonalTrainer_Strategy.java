package DB_Visualizer;

import java.sql.ResultSet;

public class PersonalTrainerStrategy implements Strategy {
    @Override
    public ResultSet execute(String query) {
        System.out.println("Executing PersonalTrainer query...");
        return Execute.execute(QueryFactory.createQuery(query));
    }
}