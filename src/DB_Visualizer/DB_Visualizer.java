package src.DB_Visualizer;

import src.Query_Factory.Query;

import java.sql.ResultSet;
import java.util.List;

public class DB_Visualizer {
    private String q_string;
    private Query query;
    private Object result;
    private List result_list;

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void generateExecute(String type, int request, int ID) {

        switch (request) {
            case 1:
                //restituisce le informazioni per id (personale ,  Utente, PT)
                strategy = new Informazioni_Strategy();
                break;
            case 2:
                //restituisce una lista dei corsi a cui l'utente è iscritto , per pt e impiegato restituisce tutti i corsi
                strategy = new Corsi_Strategy();
                break;
            case 3:
                //restituisce una lista dei PT associati per utente, restituisce una lista di tutti i PT per impiegatoù
                //se vuoi visualizzare3 ttutti i PT per l'utente basta eseguire la richiesta passando come type quello da impiegato
                strategy = new PersonalTrainer_Strategy();
                break;
            case 4:
                //restituisce orario appuntamento associato a C e P a seconda del type
                strategy = new Appuntamento_Strategy();
                break;
            case 5:
                //restituisce i messaggi inviati da un ID come mittente
                strategy = new Messaggi_Strategy();
                break;
            case 6:
                //restituisce tutti le recensioni associati all'id che gli viene passato
                //con type C restituisce le recensioni fatte da un cliente, con P le recensioni dedicate a un PT
                //con I restituisce tutte le recensioni
                strategy = new Recensioni_Strategy();
                break;
            case 7:
                //restituisce una lista degli utenti
                //cont type P restituisce una lista degli utenti associati all'id del personl trainer
                //con type I lista di tutti gli utenti
                strategy = new Clienti_Strategy();
                break;

            default:
                throw new IllegalArgumentException("Invalid request type");
        }

        result_list = strategy.execute(type,ID);

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

    public Object getResult() {
        return result;
    }

    public List<Object> getResult_list() {
        return result_list;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }


}
