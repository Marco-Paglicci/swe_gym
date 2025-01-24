package Employee_GUI_Controller;
import models.Employee;
import models.Client;
import models.Message;
import src.DB_Visualizer.DB_Visualizer;


import java.sql.ResultSet;
import java.util.ArrayList;
import src.DB_Visualizer.DB_Visualizer;;
import java.util.List;

public class Interface_Client {
    private Employee personale;
    private List<Client> Clienti_List;
    private DB_Visualizer DB;

    Interface_Client(Employee personale){
        this.personale = personale;
    }
    public void visualizza(){
        Clienti_List = getClient();
        for (Client cliente: Clienti_List){
            System.out.println(cliente.getNome()+" "+cliente.getCognome()+" "+cliente.getID());
        }
    }
    public List<Client> getClient(){
        DB.generateExecute("I",2,0);//TODO manca la lista dei clienti
        List<Client> clientlist = getclientlist();
        return clientlist;
    }
    public void aggiungi_cliente(String nome, String cognome, int type){
        //Logica per inserire un nuovo cliente nella lista -> Interfaccia new client

        //Lazy initialization
        Interface_NewClient INC = new Interface_NewClient(nome, cognome, type);
        INC.aggiungi_cliente();
    }
    public void eliminia_cliente(Client cliente){
        //TODO:Logica per eliminare il cliente con ID = cliente.getID()
    }

    public void notifica(Client cliente, String mess){
        //Logica per inviare una notifica ad un determianto cliente
        //Crea messaggio e lo condivide con il cliente

        Message m = new Message(personale.getID(),cliente.getID(),mess);
        //TODO:logica per mettere questo messaggio nella cassella del cliente sul DB

    }
}
