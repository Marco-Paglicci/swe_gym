package Employee_GUI_Controller;
import models.Employee;
import models.Client;
public class Interface_Client {
    private Employee personale;
    private Client[] Clienti_List;

    public void visualizza(){
        //Logica di visualizzazione delle opzioni
    }
    public Client[] getClient(){
        return Clienti_List;
    }
    public void aggiungi_cliente(){
        //Logica per inserire un nuovo cliente nella lista -> Interfaccia new client
    }

    public void notifica(Client cliente){//TODO: Magari passargli direttamente il cliente che vogliamo notificare
        //Logica per inviare una notifica ad un determianto cliente
        //Crea messaggio e lo condivide con il cliente
    }
}
