package Client_GUI_Controller;
import models.Client;
import java.sql.ResultSet;
public class Information_Interface {
    //TODO:nel uml questa classe contiene un oggetto PT ma credo ci vada un oggetto Utente
    private Client utente;

    public ResultSet getInformazioni(){
        //Restituisce informazioni in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        return null;
    }
    public void modifica_informazioni(){
        //Chiamata a interfaccia modifica info
    }
}
