package Client_GUI_Controller;
import java.sql.ResultSet;

public class Notification_Interface {
    public ResultSet getMessaggi(){
        //Restituisce i messaggi in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        return null;
    }
    public void message_reply(int mittente){
        //Chiamata a send messagge della classe message interface
        //TODO:Non mi smebra corretta come idea, non funzionerebbe
    }
    public void gestione_appuntamento(){
        //Chiamata a interfaccia appuntamento
    }
    public void visualizza(){
        //Classica logica per visualizzare
    }
}
