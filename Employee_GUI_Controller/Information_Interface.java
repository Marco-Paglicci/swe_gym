package Employee_GUI_Controller;
import models.Client;
import models.Employee;
import src.DB_Visualizer.DB_Visualizer;

import java.util.List;

public class Information_Interface {
    private Employee personale;
    private DB_Visualizer DB;

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
        return impiegato.get(0);
    }
    public void modifica_informazioni(){
        //todo capiamo se serve anche qui un interfaccia di modifica
    }

}
