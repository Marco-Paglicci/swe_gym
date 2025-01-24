package models;

public class Personal_Trainer {
    private int idPersonalTrainer;
    private String nome;
    private String cognome;
    private int eta;
    private String descrizione;
    private double valutazione;

    // Costruttore
    public Personal_Trainer(int idPersonalTrainer, String nome, String cognome, int eta, String descrizione, double valutazione) {
        this.idPersonalTrainer = idPersonalTrainer;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.descrizione = descrizione;
        this.valutazione = valutazione;
    }

    // Getter e Setter
    public int getIdPersonalTrainer() {
        return idPersonalTrainer;
    }

    public void setIdPersonalTrainer(int idPersonalTrainer) {
        this.idPersonalTrainer = idPersonalTrainer;
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getValutazione() {
        return valutazione;
    }

    public void setValutazione(double valutazione) {
        this.valutazione = valutazione;
    }

    @Override
    public String toString() {
        return "PersonalTrainer{" +
                "idPersonalTrainer=" + idPersonalTrainer +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", descrizione='" + descrizione + '\'' +
                ", valutazione=" + valutazione +
                '}';
    }
}
