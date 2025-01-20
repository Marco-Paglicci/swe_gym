package Client_GUI_Controller;
import models.Client;
import java.sql.ResultSet;
public class Interface_Client {
    private Client utente;

    public void visualizza_informazioni(){
        //Logica per visualizzare le informazioni -> Interfaccia informazioni
        Information_Interface II = new Information_Interface(utente);
        ResultSet RS;
        RS = II.getInformazioni();
    }
    public void visualizza_PT(){
        //Logica che porta a InterfacciaPT
        PT_Interface PT = new PT_Interface(utente);
        PT.visualizza();
    }
    public void visualizza_corsi(){
        //Logica che porta a InterfacciaCorsi
        class_Interface CI = new class_Interface(utente);
        CI.visualizza();
    }
    public void consulta_abbonamento(){
        //Logica per visualizzare il tipo di abbonamento dell'utente
        utente.getSubscrition().view_Subscription();
    }
    public void area_notifiche(){
        //Logica per accedere all'area delle notifiche -> Interfaccia notifiche
        Notification_Interface NI = new Notification_Interface(utente);
        NI.visualizza();
    }
    public void visualizza(){
        //Logica generica per la visualizzazione della pagina
    }
}
