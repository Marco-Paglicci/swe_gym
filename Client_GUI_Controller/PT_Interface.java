package Client_GUI_Controller;
import models.Client;
import src.DB_Visualizer.DB_Visualizer;
import java.sql.ResultSet;

public class PT_Interface {
    private Client utente;
    private DB_Visualizer DB;
    PT_Interface(Client utente){
        this.utente = utente;
    }
    public boolean sendMessage(){
        //chiamata a message interface per creare un nuovo messagio
        return true;
    }
    public ResultSet getPT(){
        //Restituisce i PT in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute(3,utente.getID());
        ResultSet RS = DB.getResult();
        return RS;
    }
    public void addReview(int PT_ID){
        //Chiamata a interfaccia recensioni
        Review_Interface RI = new Review_Interface(PT_ID,utente);
        RI.visualizza();
    }
    public void visualizza(){
        //Classica logica per la visualizzazione
    }
}
