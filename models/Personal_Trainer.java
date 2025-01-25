package models;

public class Personal_Trainer {
    private int ID;
    private String nome;
    private String cognome;
    private int eta;
    private String descrizione;
    private double valutazione;
    public Personal_Trainer(int ID, String nome, String cognome, int eta, String descrizione, double valutazione){
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.descrizione = descrizione;
        this.valutazione = valutazione;
    }
    public int getID(){
        return ID;
    }
    public String getNome() {
        //Dovrebbe prenderli dal DB
        return nome;
    }
    public String getCognome() {
        //Dovrebbe prenderlo dal DB
        return cognome;
    }

    public int getEta() {
        return eta;
    }



    public String getDescrizione() {
        return descrizione;
    }



    public double getValutazione() {
        return valutazione;
    }

    public void setValutazione(double valutazione) {
        this.valutazione = valutazione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
    @Override
    public String toString(){
        return "PersonalTrainer{" + "idPersonalTrainer=" + ID + ", nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", eta=" + eta +
                ", descrizione='" + descrizione + '\'' + ", valutazione=" + valutazione + '}';

    }
}
