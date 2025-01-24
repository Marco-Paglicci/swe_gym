package Client_GUI_Controller;
import java.sql.ResultSet;
import java.util.List;

import models.Client;
import models.Corso;
import src.DB_Visualizer.DB_Visualizer;
public class class_Interface {
    private DB_Visualizer DB;
    private Client utente;
    private List<Corso> corsi;
    class_Interface(Client utente){
        this.utente = utente;
    }
    public List<Corso> getCorsi(){
        //Restituisce i corsi in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("C",2, utente.getID());
        List<Corso> corsilsit = DB.getcorsilist();
        return corsilsit;
    }
    public void iscrizione_corso(int Corso_ID){
        //Logica per andare ad iscrivere l'utente con ID al corso con ID
    }
    public void visualizza(){
        //Classica logica per visualizzazione
        corsi = getCorsi();
        for(Corso corso: corsi){
            System.out.println(corso.toString());
        }
    }
}
