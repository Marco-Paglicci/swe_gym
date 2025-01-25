package Client_GUI_Controller;
import java.sql.ResultSet;
import java.util.List;

import src.DB_Visualizer.DB_Visualizer;
import models.Client;
public class Appointment_Interface {
    private DB_Visualizer DB;
    private Client utente;
    private List<String> appuntamenti;
    Appointment_Interface(Client utente){
        this.utente = utente;
    }
    public List<String> getAppuntamenti(){
        //Restituisce gli appuntamenti in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("C",4,utente.getID());
        return DB.getResult_list(); //Lista di Stringhe che contengono gli appuntamenti del cliente
    }
    public void visualizza(){
        //Classica logica per visualizzazione
        System.out.println("Gli appuntamenti futri sono:");
        appuntamenti = getAppuntamenti();
        for(String appuntamento : appuntamenti){
            System.out.println(appuntamento);
        }
    }
}
