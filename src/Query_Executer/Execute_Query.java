package src.Query_Executer;



import src.Query_Factory.Query;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Execute_Query {

    private Database DB;
    private QueryExecutionStrategy strategy;



    public Execute_Query(Database DB, QueryExecutionStrategy Strategy)
    {
        this.DB = DB;
        this.strategy = Strategy;
    }


    /**
     * Esegue una query di lettura e restituisce il ResultSet.
     *
     * @param query Oggetto Query contenente la stringa SQL.
     * @return ResultSet contenente i dati della query.
     */
    public ResultSet executeGet(Query query) {
        try {
            // Ottieni una connessione e prepara la query
            Connection connection = DB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query.getQuery());

            // Usa la strategia per eseguire la query e ottenere il ResultSet
            return strategy.executeGetQuery(query.getQuery());

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'esecuzione della query GET", e);
        }
    }


    /**
     * Esegue una query di modifica e restituisce un booleano per indicare il successo.
     *
     * @param query Oggetto Query contenente la stringa SQL.
     * @return true se l'operazione è andata a buon fine, false altrimenti.
     */
    public boolean executeModify(Query query) {
        try {
            // Ottieni una connessione e prepara la query
            Connection connection = DB.getConnection();
            PreparedStatement statement = connection.prepareStatement(query.getQuery());

            // Usa la strategia per eseguire la query
            return strategy.executeModifyQuery(query.getQuery());

        } catch (SQLException e) {
            throw new RuntimeException("Errore durante l'esecuzione della query MODIFY", e);
        }
    }


    public Query_Result  Execute(int request, Query query) {
        switch (request) {
            case 1: // Modalità get
                return new Query_Result(executeGet(query));
            case 2: // Modalità modify
                return new Query_Result(executeModify(query));
            default:
                throw new IllegalArgumentException("Invalid request type");
        }
    }



}
