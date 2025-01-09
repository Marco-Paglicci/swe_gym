package Client_GUI_Controller;
import models.Client;
public class Interface_Client {
    private Client utente;

    public void visualizza_informazioni(int ID){
        //Logica per visualizzare le informazioni -> Interfaccia informazioni
    }
    //TODO: ci sarebbe direttamente la funzione modifica infor sul UML
    public void visualizza_PT(){
        //Logica che porta a InterfacciaPT
    }
    public void visualizza_corsi(){
        //Logica che porta a InterfacciaCorsi
    }
    public void consulta_abbonamento(){
        //Logica per visualizzare il tipo di abbonamento dell'utente
        utente.getSubscrition().view_Subscription();
    }
    public void area_notifiche(){
        //Logica per accedere all'area delle notifiche -> Interfaccia notifiche
    }
    public void visualizza(){
        //Logica generica per la visualizzazione della pagina
    }
}
