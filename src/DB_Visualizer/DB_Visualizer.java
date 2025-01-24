package src.DB_Visualizer;

import src.Query_Factory.Query;

import java.sql.ResultSet;

public class DB_Visualizer {
    private String q_string;
    private Query query;
    private ResultSet result;
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void generateExecute( int request, int ID) {

        switch (request) {
            case 1:
                strategy = new Informazioni_Strategy();
                break;
            case 2:
                strategy = new Corsi_Strategy();
                break;
            case 3:
                strategy = new PersonalTrainer_Strategy();
                break;
            case 4:
                strategy = new Appuntamento_Strategy();
                break;
            case 5:
                strategy = new Messaggi_Strategy();
                break;
            case 6:
                strategy = new Recensioni_Strategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid request type");
        }
        //todo add get clienti , get appunbatmetni , get lista clienti totale
        // todo add string type

        result = strategy.execute(ID);
    }

    public String getQ_string() {
        return q_string;
    }

    public void setQ_string(String q_string) {
        this.q_string = q_string;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }


}
