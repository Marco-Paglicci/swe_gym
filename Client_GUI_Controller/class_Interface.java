package Client_GUI_Controller;
import java.sql.ResultSet;

import models.Client;
import src.DB_Visualizer.DB_Visualizer;
public class class_Interface {
    private DB_Visualizer DB;
    private Client utente;
    class_Interface(Client utente){
        this.utente = utente;
    }
    public ResultSet getCorsi(){
        //Restituisce i corsi in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute(2, utente.getID());
        ResultSet RS = DB.getResult();
        return RS;
    }
    public void iscrizione_corso(int Corso_ID){
        //Logica per andare ad iscrivere l'utente con ID al corso con ID
    }
    public void visualizza(){
        //Classica logica per visualizzazione
    }
}
