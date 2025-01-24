package PT_GUI_Controller;
import models.Personal_Trainer;
import src.DB_Visualizer.DB_Visualizer;
import java.sql.ResultSet;

public class Review_Interface {
    private Personal_Trainer PT;
    private DB_Visualizer DB;


    public void visualizza() {
        // Logica per visualizzare le recensioni
        System.out.println("Visualizzando recensioni per il PT: " + PT.getNome());
        ResultSet recensioni =  getRecensione();
    }

    public ResultSet getRecensione() {
        // Logica per ottenere una recensione
        System.out.println("Recuperando una recensione dal DB...");
        DB.generateExecute(6, PT.getID());
        ResultSet RS = DB.getResult();
        return RS;
    }
}
