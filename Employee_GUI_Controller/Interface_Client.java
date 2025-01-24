package Employee_GUI_Controller;
import models.Employee;
import models.Client;
import models.Message;


import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

public class Interface_Client {
    private Employee personale;
    private Client[] Clienti_List;

    Interface_Client(Employee personale){
        this.personale = personale;
    }
    public void visualizza(){
        Clienti_List = getClient();
        for (Client cliente: Clienti_List){
            System.out.println(cliente.getNome()+" "+cliente.getCognome()+" "+cliente.getID());
        }
    }
    public Client[] getClient(){
        ResultSet RS = getClientDB(); //TODO:inserire la funzione dal DB
        List<Client> clienti = new ArrayList<>();
        try {
            while (RS != null && RS.next()) {
                Client client = new Client(
                        RS.getInt("id"),
                        RS.getString("nome"),
                        RS.getString("cognome")
                        );
                clienti.add(client);
            }
        }catch(Exception e){ e.printStackTrace();}
        return clienti.toArray(new Client[0]);
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
