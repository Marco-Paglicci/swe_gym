package Employee_GUI_Controller;
import models.Employee;
public class Employee_Interface {
    private Employee personale;
    Interface_Client IC;
    class_Interface CI;
    Interface_PT IP;

    Employee_Interface(Employee personale){
        this.personale = personale;
        this.IC = new Interface_Client(personale);
        this.CI = new class_Interface(personale);
        this.IP = new Interface_PT(personale);
    }
    public void visualizza_informazioni(){
        // Logica per visualizzare le informazioni -> Interfaccia informazioni
    }
    public void tabella_clienti(){
        //Logica per mostrare la tabella dei clienti -> Interfaccia clienti
        IC.visualizza();
    }
    public void lista_corsi(){
        //Logica per visualizzare la tabella di tutti i corsi -> Interfaccia corsi
        CI.visualizza();
    }
    public void gestione_PT(){
        //Logica per gestire i personal trainer -> Interfaccia PT
        IP.visualizza();
    }
    public void visualizza(){
        //Logica per visualizzare le opzioni ...

        System.out.println("Opzioni disponibili: ");
        System.out.println("1. Tabella clienti");
        System.out.println("2. Lista corsi");
        System.out.println("3. Gestione PT");
        System.out.println("4. Visualizza informazioni");
    }
}
