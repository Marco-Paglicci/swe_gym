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
    private List<Corso> corsiIscritto;
    class_Interface(Client utente){
        this.utente = utente;
    }
    public List<Corso> getCorsiIscritto(){
        //Restituisce i corsi a cui l'utente con ID è iscritto in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("C",2, utente.getID());
        return DB.getResult_list(); //Lista di corsi
    }
    public List<Corso> getCorsi(){
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("P",2, utente.getID());
        return DB.getResult_list(); //Lista di corsi
    }
    public void iscrizione_corso(int Corso_ID){
        //Logica per andare ad iscrivere l'utente con ID al corso con ID
        //todo iscrizione ad un corso
    }
    public void visualizza(){
        //Classica logica per visualizzazione
        corsi = getCorsi();
        System.out.println("I corsi disponibili sono: ");
        for(Corso corso: corsi){
            System.out.println(corso.toString());
        }

        corsiIscritto = getCorsiIscritto();
        System.out.println("I corsi a cui sei iscritto sono");
        for(Corso corso: corsiIscritto){
            System.out.println(corso.toString());
        }
    }
}
