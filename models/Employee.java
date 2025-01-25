package models;

public class Employee {
    private int ID;
    private String nome;
    private String cognome;

    public Employee(int ID, String nome, String cognome) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString(){
        return "Impiegato "+ID+", Nome: "+nome+", Cognome: "+cognome;
    }
}
