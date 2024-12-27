package DB_Visualizer;// Concrete Strategies

import java.sql.ResultSet;

public class InformazioniStrategy implements Strategy {
    @Override
    public ResultSet execute(String query) {
        System.out.println("Executing Informazioni query...");
        return Execute.execute(QueryFactory.createQuery(query));
    }
}