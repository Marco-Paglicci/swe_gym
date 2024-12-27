package DB_Visualizer;

public class CorsiStrategy implements Strategy {
    @Override
    public ResultSet execute(String query) {
        System.out.println("Executing Corsi query...");
        return Execute.execute(QueryFactory.createQuery(query));
    }
}