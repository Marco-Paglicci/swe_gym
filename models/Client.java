package models;
import models.Subscrition;
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
}
