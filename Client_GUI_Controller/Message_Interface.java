package Client_GUI_Controller;
import models.Message;
import src.DB_Add.Add_Controller;
public class Message_Interface {
    private Message messaggio;
    private Add_Controller AC;

    public void sendMessage(Message M){
        //Implementa una logica per inviare il messaggio M tramite DB
        if(AC.add_messaggio(M,"C")){
            System.out.println("Messaggio inviato correttamente");
        }else System.out.println("Invio del messaggio non riuscito...");
    }

    public void visualizza(){
        //Logica classica per la visualizzazione
        System.out.println("Scrivi ed invia un messaggio");
    }
}
