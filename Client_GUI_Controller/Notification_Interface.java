package Client_GUI_Controller;
import java.sql.ResultSet;
import java.util.List;

import models.Message;
import models.Client;
import src.DB_Visualizer.DB_Visualizer;
public class Notification_Interface {
    private DB_Visualizer DB;
    private Client utente;
    private List<Message> messaggi;
    Notification_Interface(Client utente){
        this.utente = utente;
    }
    public List<Message> getMessaggi(){
        //Restituisce i messaggi in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("C",5, utente.getID());
        List<Message> messaggilist = DB.getmessaggilist();
        return messaggilist;
    }
    public void message_reply(int destinatario, String message){
        //Chiamata a send messagge della classe message interface
        //TODO:Secondo me possiamo mandare il messaggio direttamente da qui senza utilizzare l'interfaccia
        Message_Interface MI = new Message_Interface();
        Message M = new Message(utente.getID(),destinatario , message);
        MI.sendMessage(M); //TODO:In realtà credo che serva perché qua dovremo caricare il messaggio sul DB
    }
    public void gestione_appuntamento(){
        //Chiamata a interfaccia appuntamento
        Appointment_Interface AI = new Appointment_Interface(utente);
        AI.visualizza();
    }
    public void visualizza(){
        //Classica logica per visualizzare
        messaggi = getMessaggi();
        for(Message messaggio : messaggi){
            System.out.println("Messagio da "+messaggio.getSender()+ ": "+messaggio.getContent());
        }
    }
}
