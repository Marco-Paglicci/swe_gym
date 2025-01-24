package Client_GUI_Controller;
import models.Client;
import java.sql.ResultSet;
import src.DB_Visualizer.DB_Visualizer;
public class Information_Interface {
    //TODO:nel uml questa classe contiene un oggetto PT ma credo ci vada un oggetto Utente
    private Client utente;
    private DB_Visualizer DB;
    private ResultSet RS;
    public ResultSet getInformazioni(){
        //Restituisce informazioni in formato ResultSet dal DB
        DB.generateExecute(1, utente.getID());
        RS = DB.getResult();

        return null;
    }
    public void modifica_informazioni(){
        //Chiamata a interfaccia modifica info
    }
}
