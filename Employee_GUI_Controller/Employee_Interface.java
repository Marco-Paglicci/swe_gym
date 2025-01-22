package Employee_GUI_Controller;
import models.Employee;
public class Employee_Interface {
    private Employee personale;

    public void visualizza_informazioni(){
        // Logica per visualizzare le informazioni -> Interfaccia informazioni
    }
    public void tabella_clienti(){
        //Logica epr mostrare la tabella dei clienti -> Interfaccia clienti
        Interface_Client IC = new Interface_Client(personale);
        IC.visualizza();
    }
    public void lista_corsi(){
        //Logica per visualizzare la tabella di tutti i corsi -> Interfaccia corsi
        class_Interface CI = new class_Interface(personale);
        CI.visualizza();
    }
    public void gestione_PT(){
        //Logica per gestire i personal trainer -> Interfaccia PT
        Interface_PT IP = new Interface_PT(personale);
        IP.visualizza();
    }
    public void visualizza(){
        //Logica per visualizzare le opzioni ...
    }
}
