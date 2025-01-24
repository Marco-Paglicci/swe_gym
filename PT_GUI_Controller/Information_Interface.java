package PT_GUI_Controller;
import models.Personal_Trainer;
import java.sql.ResultSet;
import src.DB_Visualizer.DB_Visualizer;

public class Information_Interface {
    private Personal_Trainer PT;
    private Modify_Interface MI;
    private DB_Visualizer DB;

    Information_Interface(Personal_Trainer PT){
        this.PT = PT;
        this.MI = new Modify_Interface(PT);
    }
    public void visualizza() {
        // Logica per visualizzare le informazioni del PT
        PT = getInformazioni();
        System.out.println(PT.toString());
    }

    public Personal_Trainer getInformazioni() {
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute();//TODO:metodo per informazioni di PT
        Personal_Trainer PTDB = DB.getPersonalTrainer();
        return PTDB;
    }

    public void modificaInformazioni() {
        // Logica per modificare le informazioni del Personal Trainer sul DB
        MI.visualizza();
    }
}
