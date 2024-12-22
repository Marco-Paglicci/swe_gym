public class Personal_Trainer {
    private String ID; //TODO:magari farlo int ??
    private String nome;
    private String cognome;
    public Personal_Trainer(String ID, String nome, String cognome){
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
    }
    public String getID(){
        return ID;
    }
}
