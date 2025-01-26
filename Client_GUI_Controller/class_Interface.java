package Client_GUI_Controller;
import java.sql.ResultSet;
import java.util.List;
import src.DB_Add.Add_Controller;
import models.Client;
import models.Corso;
import src.DB_Visualizer.DB_Visualizer;
public class class_Interface {
    private DB_Visualizer DB = new DB_Visualizer();
    private Add_Controller AC = new Add_Controller();
    private Client utente;
    private List<Corso> corsi;
    private List<Corso> corsiIscritto;
    public class_Interface(Client utente){
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
    public void iscrizione_corso(Corso corso){
        //Logica per andare ad iscrivere l'utente con ID al corso con ID
        if(AC.add_corso(utente.getID(),corso,"C")){
            System.out.println("Iscrizione avvenuta con successo");
        }else System.out.println("Iscrizione negata...");
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
