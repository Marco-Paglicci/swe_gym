package Client_GUI_Controller;
import models.Client;
public class Modify_Interface {
    private Client utente;

    Modify_Interface(Client user){
        utente = user;
    }
    public void modificaInformazioni(String nome, String Cognome){
        //TODO: solo nome e cognome?
        //Logica che accede al DB e modifica i dati dell'utente dato
    }
    public void visualizza(){
        //Classica funzione di visualizzazione
    }
}
