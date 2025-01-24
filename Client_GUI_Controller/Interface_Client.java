package Client_GUI_Controller;
import PT_GUI_Controller.Client_Interface;
import models.Client;
import java.sql.ResultSet;
public class Interface_Client {
    private Client utente;
    Information_Interface II;
    class_Interface CI;
    PT_Interface PT;
    Notification_Interface NI;
    public Interface_Client(Client cliente){
        this.utente = cliente;
        this.II = new Information_Interface(utente);
        this.PT = new PT_Interface(utente);
        this.CI = new class_Interface(utente);
        this.NI = new Notification_Interface(utente);

    }

    public void visualizza_informazioni(){
        //Logica per visualizzare le informazioni -> Interfaccia informazioni
        II.visualizza();
    }
    public void visualizza_PT(){
        //Logica che porta a InterfacciaPT
        PT.visualizza();
    }
    public void visualizza_corsi(){
        //Logica che porta a InterfacciaCorsi
        CI.visualizza();
    }
    public void consulta_abbonamento(){
        //Logica per visualizzare il tipo di abbonamento dell'utente
        utente.getSubscrition().view_Subscription();
        //TODO:Magari lo possoiamo aggiungere all'area informazioni
    }
    public void area_notifiche(){
        //Logica per accedere all'area delle notifiche -> Interfaccia notifiche
        NI.visualizza();
    }
    public void visualizza(){
        //Logica generica per la visualizzazione della pagina
        System.out.println("Opzioni disponibili: ");
        System.out.println("1. Visualizza personal trainer");
        System.out.println("2. Visualizza la lista dei corsi");
        System.out.println("3. Accedi all'area notifiche");
        System.out.println("4. Visualizza informazioni");
    }
}
