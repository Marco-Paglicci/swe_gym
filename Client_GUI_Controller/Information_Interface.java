package Client_GUI_Controller;
import models.Client;
import java.sql.ResultSet;
import java.util.List;

import src.DB_Visualizer.DB_Visualizer;
public class Information_Interface {
    private Client utente;
    private DB_Visualizer DB;
    Information_Interface(Client utente){
        this.utente = utente;
    }
    public void visualizza(){
        System.out.println("Informazioni dell'utente:");
        utente = getInformazioni();
        System.out.println(utente.toString());
    }
    public Client getInformazioni(){
        //Restituisce informazioni in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("C",1, utente.getID());
        List<Client> cliente = DB.getResult_list();
        return cliente.get(0);
    }
    public void modifica_informazioni(){
        //Chiamata a interfaccia modifica info
        Modify_Interface MI =  new Modify_Interface(utente);
        MI.visualizza();
    }
}
