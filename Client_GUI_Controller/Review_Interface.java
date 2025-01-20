package Client_GUI_Controller;
import src.DB_Visualizer.DB_Visualizer;
import models.Client;

public class Review_Interface {
    private int PT_ID;
    private int REV_ID;
    private Client utente;
    private DB_Visualizer DB;
    Review_Interface(int PT_ID, Client utente){
        this.PT_ID = PT_ID;
        this.utente = utente;
    }
    public boolean sendRecensione(){
        //Logica per mandare una recensione ad un PT tramite DB
        //TODO:Come aggiungo una recensione al personal trainer con quell'ID
        //TODO:Il REV_ID dovra essere univoco come lo facciamo ?
        DB.generateExecute(6, utente.getID());
        return true;
    }
    public void visualizza(){
        //Classica logica per gestire la visualizzazione
    }

}
