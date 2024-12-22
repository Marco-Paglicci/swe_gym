package PT_GUI_Controller;
import models.Personal_Trainer;
import java.sql.ResultSet;

public class Information_Interface {
    private Personal_Trainer PT;

    public void visualizza() {
        // Logica per visualizzare le informazioni del PT
        System.out.println("Informazioni del PT: " + PT.getNome() + " " + PT.getCognome());
    }

    public ResultSet getInformazioni() {
        // Qui si dovrebbe implementare la logica per restituire un ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        return null;
    }

    public void modificaInformazioni() {
        // Logica per modificare le informazioni del Personal Trainer sul DB
        System.out.println("Modifica informazioni per il PT: " + PT.getID());
    }
}
