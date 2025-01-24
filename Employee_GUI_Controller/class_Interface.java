package Employee_GUI_Controller;
import models.Employee;
import models.Corso;
import src.DB_Visualizer.DB_Visualizer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class class_Interface {
    private Employee personale;
    private List<Corso> Corsi_List;
    private DB_Visualizer DB;

    class_Interface(Employee personale){
        this.personale = personale;
    }
    public void add_class(){
        //Logica per aggiungere un corso
        //TODO:Metodo per aggiungere corso al DB
    }
    public void remove_class(){
        //Logica per rimuovere un corso
        //TODO:Metodo per rimuovere un corso dal DB
    }

    public List<Corso> getCorsi(){
        DB.generateExecute("I",3,0); //TODO manca
        List<Corso> corsi = DB.getcorsilist();
        return corsi;
    }
    public void visualizza(){
        Corsi_List = getCorsi();
        for (Corso corso: Corsi_List) {
            System.out.println(corso.toString());
        }
    }

}
