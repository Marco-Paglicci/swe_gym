package Employee_GUI_Controller;
import models.Employee;
import models.Client;
import models.Message;
import src.DB_Visualizer.DB_Visualizer;
import src.DB_Remove.Remove_Controller;
import src.DB_Add.Add_Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import src.DB_Visualizer.DB_Visualizer;
import java.util.List;

public class Interface_Client {
    private Employee personale;
    private List<Client> Clienti_List;
    private DB_Visualizer DB;
    private Remove_Controller RC;
    private Add_Controller AC;

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
        DB.generateExecute("I",7,personale.getID());
        return DB.getResult_list(); //Lista di clienti
    }
    public void aggiungi_cliente(int ID,String nome, String cognome){
        //Logica per inserire un nuovo cliente nella lista -> Interfaccia new client
        //Lazy initialization
        Interface_NewClient INC = new Interface_NewClient(ID,nome, cognome);
        INC.aggiungi_cliente();
    }
    public void eliminia_cliente(Client cliente){
        if(RC.remove_cliente(personale.getID(), cliente, "I")){
            System.out.println("Cancellazione dell'utente avvenuta con successo");
        }else System.out.println("Cancellazione dell'utente negata...");

    }

    public void notifica(Client cliente, String mess){
        //Logica per inviare una notifica ad un determianto cliente
        //Crea messaggio e lo condivide con il cliente
        Message m = new Message(personale.getID(),cliente.getID(),mess);
        if(AC.add_messaggio(m,"I")){
            System.out.println("Messaggio inviato con successo");
        }else System.out.println("Invio messaggio negato...");

    }
}
