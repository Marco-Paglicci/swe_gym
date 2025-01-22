package Employee_GUI_Controller;
import models.Employee;

import java.sql.ResultSet;

public class class_Interface {
    private Employee personale;
    private String[] Corsi_List; //TODO:Ha senso fare una classe corso ??

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

    public ResultSet getCorsi(){
        //TODO:Prendere la lista di tutti i corsi disponibili
        return null;
    }
    public void visualizza(){
        //Corsi_List = getCorsi(); TODO:Ci dovrà essere un alogica del genere
        for (String corso: Corsi_List) {
            System.out.println(corso);
        }
    }

}
