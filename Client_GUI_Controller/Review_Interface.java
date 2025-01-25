package Client_GUI_Controller;
import models.Personal_Trainer;
import src.DB_Visualizer.DB_Visualizer;
import models.Client;
import src.DB_Add.Add_Controller;

public class Review_Interface {
    private Personal_Trainer PT;
    private Client utente;
    private DB_Visualizer DB;
    private Add_Controller AC;
    Review_Interface(Personal_Trainer PT, Client utente){
        this.PT = PT;
        this.utente = utente;
    }
    public void sendRecensione(int valutazione, String recensione){
        //Logica per mandare una recensione ad un PT tramite DB
        if(AC.add_recensione(utente.getID(),PT,"C",valutazione, recensione)){
            System.out.println("Recensione inviate con successo");
        }else System.out.println("Recensione non inviata errore nel DB...");
    }
    public void visualizza(){
        //Classica logica per gestire la visualizzazione
    }

}
