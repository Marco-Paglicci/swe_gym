package PT_GUI_Controller;
import models.Personal_Trainer;
import java.sql.ResultSet;
import src.DB_Visualizer.DB_Visualizer;

public class Information_Interface {
    private Personal_Trainer PT;
    private DB_Visualizer DB;

    Information_Interface(Personal_Trainer PT){
        this.PT = PT;
    }
    public void visualizza() {
        // Logica per visualizzare le informazioni del PT
        System.out.println("Informazioni del PT: " + PT.getNome() + " " + PT.getCognome());
    }

    public ResultSet getInformazioni() {
        System.out.println("Recuperando informazioni dal database...");
        //DB.generateExecute();
        return null;
        //TODO:nel DB dobbiamo dividere l'accesso alle informazione dei clienti da quello dei pt e impiegati
    }

    public void modificaInformazioni() {
        // Logica per modificare le informazioni del Personal Trainer sul DB
        System.out.println("Modifica informazioni per il PT: " + PT.getID());
    }
}
