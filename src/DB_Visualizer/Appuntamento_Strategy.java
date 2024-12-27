package DB_Visualizer;

public class AppuntamentoStrategy implements Strategy {
    @Override
    public ResultSet execute(String query) {
        System.out.println("Executing Appuntamento query...");
        return Execute.execute(QueryFactory.createQuery(query));
    }
}
