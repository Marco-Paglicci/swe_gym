package Employee_GUI_Controller;
import models.Client;
import models.Subscrition;
import src.DB_Add.Add_Controller;
import java.sql.Date;

public class Interface_NewClient {
    private String nome;
    private String cognome;
    private int ID;
    private Add_Controller AC;
    Interface_NewClient(int ID,String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
        this.ID = ID;
    }
    public void aggiungi_cliente(){
        //Logica per la creazione di un nuovo abbonato
        //inizializzata nella GUI
        Date scadenza = null;
        Subscrition s1 = new Subscrition(true,scadenza);
        Client c1 = new Client(ID,nome,cognome, s1);
        if(AC.add_cliente(0,c1,"I")){
            System.out.println("Cliente aggiunto al sistema con successo");
        }else System.out.println("Aggiunta del cliente negata...");
    }
}
