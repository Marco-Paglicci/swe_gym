package Employee_GUI_Controller;
import models.Client;
import models.Subscrition;
public class Interface_NewClient {
    private String nome;
    private String cognome;
    private int type;
    Interface_NewClient(String nome, String cognome, int type){
        this.nome = nome;
        this.cognome = cognome;
        this.type = type;
    }
    public void aggiungi_cliente(){
        //Logica per la creazione di un nuovo abbonato
        Subscrition s1 = new Subscrition(); //todo merge then fix issue
        Client c1 = new Client(23,nome,cognome, s1);
        //TODO:Andrà aggiunto nel DB, capiamo come gestire l'ID
    }
}
