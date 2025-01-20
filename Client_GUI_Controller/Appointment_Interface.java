package Client_GUI_Controller;
import java.sql.ResultSet;
import src.DB_Visualizer.DB_Visualizer;
import models.Client;
public class Appointment_Interface {
    private DB_Visualizer DB;
    private Client utente;
    Appointment_Interface(Client utente){
        this.utente = utente;
    }
    public ResultSet getAppuntamenti(){
        //Restituisce gli appuntamenti in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute(4,utente.getID());
        ResultSet RS = DB.getResult();
        return RS;
    }
    public void esporta(){
        //TODO:non so cosa volevamo intendere
    }
    public void visualizza(){
        //Classica logica per visualizzazione
    }
}
