package Client_GUI_Controller;
import models.Client;
import src.DB_Modify.Modify_Controller;

public class Modify_Interface {
    private Client utente;

    Modify_Controller MC = new Modify_Controller();
    public Modify_Interface(Client user){
        utente = user;
    }
    public void modificaInformazioni(Client user,String nome,String cognome){
        //Logica che accede al DB e modifica i dati dell'utente dato
        if(MC.modifica_informazioni(user.getID(),nome,cognome,"C"))
        {
            System.out.println("Modifica avvenuta con successo");
        }else {
            System.out.println("La modifica non è andata a buon fine");
        }
    }
    public void visualizza(){
        //Classica funzione di visualizzazione
        System.out.println("Pagina di modifica delle informazioni");
    }
}
