package models;
import models.Subscrition;

import java.sql.Date;
import java.sql.Time;

public class Client {
    private int ID;
    private String nome;
    private String cognome;


    private Subscrition abbonamento;

    public Client(int ID, String nome, String cognome, Subscrition abbonamento) { //Ctor
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.abbonamento = abbonamento;
    }

    public Client(int ID, String nome, String cognome) { //Ctor
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getID(){
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Subscrition getSubscrition(){
        return abbonamento;
    }

    public void setAbbonamento(Subscrition abbonamento) {
        this.abbonamento = abbonamento;
    }
}
