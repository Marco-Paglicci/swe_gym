package Employee_GUI_Controller;
import models.Client;
import models.Subscrition;
public class Interface_NewClient {
    private Client cliente;

    public void aggiungi_cliente(String nome, String cognome, int type){
        //Logica per la creazione di un nuovo abbonato
        Subscrition s1 = new Subscrition(); //todo merge then fix issue
        Client c1 = new Client(23,nome,cognome, s1);
    }
}
