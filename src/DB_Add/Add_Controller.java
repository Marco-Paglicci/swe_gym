package src.DB_Add;

import models.Client;
import models.Corso;
import models.Message;
import models.Personal_Trainer;
import src.Query_Executer.Database;
import src.Query_Executer.Execute_Query;
import src.Query_Executer.QueryExecutionStrategy;
import src.Query_Factory.Query;
import src.Query_Factory.QueryFactory;
import src.Query_Factory.QueryFactory_Imp;

import java.sql.Connection;
import java.sql.ResultSet;

public class Add_Controller {

    boolean result = false;
    String query;
    QueryFactory_Imp QF = new QueryFactory_Imp();
    Query Qy;
    Execute_Query EQ = new Execute_Query();


    /*----------------------------------------QUERY DI ADD-------------------------------*/


    public boolean add_recensione(int ID, Personal_Trainer PT, String type, int valutazione, String recensione) {
        System.out.println(" add recensione");

        switch (type) {

            case "C":
                query = "INSERT INTO recensione(idPersonaltrainer,idUtente,valutazione,recensione) " +
                        "VALUES ( " + PT.getID() + "," +
                        ID + "," +
                        valutazione + "," +
                        recensione + ")";


            case "I":

                query = "DELETE FROM recensioni " +
                        "WHERE idUtente = " + ID + " AND idPersonaltrainer = " + PT.getID() + ")";

                break;
        }
        Qy = QF.createQuery(query);
        System.out.println("Query creata : " + Qy.toString());
        result = EQ.executeModify(Qy);
        if (result) {
            return result;
        } else

            System.out.println("errore update Query");
        return false;
    }

    public boolean add_messaggio(Message M, String type) {
        System.out.println(" add Messaggio");
        switch (type) {

            case "C":
                query = "INSERTO INTO messaggio_u_pt (mittente,destinatario,messaggio)" +
                        "VALUES ( " + M.getSender() + "," + M.getReceiver() + "," + M.getContent() + ")";
                break;


            case "P":

                query = "INSERTO INTO messaggio_pt_u (mittente,destinatario,messaggio)" +
                        "VALUES ( " + M.getSender() + "," + M.getReceiver() + "," + M.getContent() + ")";
                break;


            case "I":

                query = "INSERTO INTO messaggio_p_u (mittente,destinatario,messaggio)" +
                        "VALUES ( " + M.getSender() + "," + M.getReceiver() + "," + M.getContent() + ")";
                break;
        }
        Qy = QF.createQuery(query);
        result = EQ.executeModify(Qy);
        if (result) {
            return result;
        } else

            System.out.println("errore add message");
        return false;
    }

    public boolean add_corso(int ID, Corso corso, String type) {
        System.out.println("adding corso ... ");

        switch (type) {


            case "C":

                query = "INSERTO INTO partecipazione (idUtente,idCorso)" +
                        "VALUES ( " + ID + "," + corso.getId() + ")";
                break;


            case "I":

                query = "INSERT INTO corsi (idcorsi, nome, orario_inizio, orario_fine, partecipanti)" +
                        "VALUES (" + corso.getId() + ",'" +
                        corso.getNome() + "'," +
                        corso.getDurata() + "," +
                        corso.getDurata()  + "," +
                        corso.getIscritti() + ")";
                break;
        }
        Qy = QF.createQuery(query);
        result = EQ.executeModify(Qy);
        if (result) {
            return true;
        } else

            System.out.println("errore add Corso");
        return false;
    }

    public boolean add_cliente(int ID, Client cliente, String type) {
        System.out.println(" add client");

        switch (type) {


            case "P":

                query = "INSERTO INTO affilliazione (idUtente,idPersonaltrainer)" +
                        "VALUES ( " + cliente.getID() + "," + ID + ")";
                break;


            case "I":

                query = "INSERT INTO utenti (idUtenti, Nome, Cognome, metodo_di_pagamento, scadenza, premium) " +
                        "VALUES (" + cliente.getID() + ", '" + cliente.getNome() + "', '" + cliente.getCognome() + "', " +
                        "'carta', '" + cliente.getSubscrition().getExpiration() + "', " + cliente.getSubscrition().isSub_type() + ")";

                break;
        }
        Qy = QF.createQuery(query);
        result = EQ.executeModify(Qy);
        if (result) {
            return true;
        } else
            System.out.println("errore update Query");
        return false;
    }

    public boolean add_appuntamento(int ID, int id_, String orario, String type) {
        System.out.println(" add appuntamento");

        switch (type) {


            case "C":

                query = "INSERTO INTO appuntamento (idUtente,idPersonaltrainer,orario)" +
                        "VALUES ( " + ID + "," + id_ + ",'" + orario + "')";
                break;


            case "P":

                query = "INSERTO INTO appuntamento (idUtente,idPersonaltrainer,orario)" +
                        "VALUES ( " + id_ + "," + ID + ",'" + orario + "')";
                break;
        }
        Qy = QF.createQuery(query);
        result = EQ.executeModify(Qy);
        if (result) {
            return result;
        } else

            System.out.println("errore update Query");
        return false;
    }
}
