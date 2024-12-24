package models;
import models.Subscrition;
public class Client {
    private int ID;
    private String nome;
    private String cognome;

    private Subscrition abbonamento;

    public int getID(){
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
