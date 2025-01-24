package models;

import java.sql.Time;

public class Corso {
    private int id;
    private String nome;
    private Time durata;
    private int iscritti;

    public Corso(int id, String nome, Time durata, int iscritti){
        this.id = id;
        this.nome = nome;
        this.durata = durata;
        this.iscritti = iscritti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getDurata() {
        return durata;
    }

    public void setDurata(Time durata) {
        this.durata = durata;
    }

    public int getIscritti() {
        return iscritti;
    }

    public void setIscritti(int iscritti) {
        this.iscritti = iscritti;
    }

    @Override
    public String toString(){
        return "Corso: "+nome+", Durata: "+durata+" ore, Iscritti: "+iscritti;
    }
}
