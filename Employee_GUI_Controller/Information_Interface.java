package Employee_GUI_Controller;
import models.Client;
import models.Employee;
import src.DB_Visualizer.DB_Visualizer;
import src.DB_Modify.Modify_Controller;
import java.util.List;

public class Information_Interface {
    private Employee personale;
    private DB_Visualizer DB;
    private Modify_Controller MC;

    public void visualizza(){
        System.out.println("Informazioni dell'impiegato:");
        personale = getInformazioni();
        System.out.println(personale.toString());
    }
    public Employee getInformazioni(){
        //Restituisce informazioni dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("I",1, personale.getID());
        List<Employee> impiegato = DB.getResult_list();
        return impiegato.getFirst();
    }
    public void modifica_informazioni(int ID, String nome, String cognome){
        if(MC.modifica_informazioni(ID, nome, cognome, "I")){
            System.out.println("Modifica avvenuta con successo");
        }else System.out.println("Modifica negata...");
    }

}
