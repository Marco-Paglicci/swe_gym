package Client_GUI_Controller;
import models.Message;
public class Message_Interface {
    private Message messaggio;

    public Message newMessage(int mittente, int destinatario, String messaggio){
        //Logica per creare un nuovo messaggio e per restituirlo
        Message mes = new Message(mittente,destinatario,messaggio);
        return mes;
    }
    public static boolean sendMessage(Message M){
        //Implementa una logica per inviare il messaggio M tramite DB
        return true; //se va a buon fine
    }

    public void visualizza(){
        //Logica classica per la visualizzazione
    }
}
