package Employee_GUI_Controller;
import models.Personal_Trainer;
import models.Employee;
public class Interface_PT {
    private Personal_Trainer[] PT_list;
    private Employee personale;
    Interface_PT(Employee personale){
        this.personale = personale;
    }

    public void visualizza(){
        System.out.println("Pagine personale: "+personale.getNome());
        System.out.println("Logica per visualizzare la lista di tutti i PT");
        //PT_list = getPT(); TODO:dovrà essere una cosa del genere
        for(Personal_Trainer PT : PT_list){
            System.out.println("Nome: "+ PT.getNome());
            System.out.println("Cognome: "+ PT.getCognome());
            System.out.println("ID: "+ PT.getID());
        }

    }
    //TODO:Aggiungere la possibiltà di eliminare o aggiungere un PT ?

    public void getPT(){
        //TODO:Logica per estrarre dal DB e metterli nella lista dei PT
        System.out.println("Recupero i persnal trainer disponibili dal DB...");
    }
}
