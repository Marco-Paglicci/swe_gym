package Client_GUI_Controller;
import models.Client;
import java.sql.ResultSet;
import src.DB_Visualizer.DB_Visualizer;
public class Information_Interface {
    private Client utente;
    private DB_Visualizer DB;
    private ResultSet RS;
    Information_Interface(Client utente){
        this.utente = utente;
    }
    public ResultSet getInformazioni(){
        //Restituisce informazioni in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute(1, utente.getID());
        RS = DB.getResult();
        return RS;
    }
    public void modifica_informazioni(){
        //Chiamata a interfaccia modifica info
        Modify_Interface MI =  new Modify_Interface(utente);
        MI.visualizza();
    }
}
