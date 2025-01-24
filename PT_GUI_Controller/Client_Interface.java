package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;
import src.DB_Visualizer.DB_Visualizer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Client_Interface {
    private Personal_Trainer PT;
    private Client[] client_list;
    private DB_Visualizer DB;
    Book_Interface BI;

    Client_Interface(Personal_Trainer PT){
        this.PT = PT;
         this.BI = new Book_Interface(PT);
    }
    public Client[] getClienti() {
        // Logica per recuperare i clienti
        System.out.println("Recupero informazione dal database...");
        DB.generateExecute();//TODO non c'è ancora la getClienti nel DB
        ResultSet RS = DB.getResult();

        List<Client> clienti = new ArrayList<>();

        try{
            while(RS.next()){
                Client cliente = new Client(
                        RS.getInt("U_ID"),
                        RS.getString("nome"),
                        RS.getString("cognome")
                );
                clienti.add(cliente);
            }
        }catch(Exception e){e.printStackTrace();}

        return clienti.toArray(new Client[0]);
    }

    public void visualizza() {
        // Logica per visualizzare i clienti
        System.out.println("Visualizzando clienti per il PT: " + PT.getNome());
        client_list = getClienti();
        for(Client cliente: client_list){
            System.out.println(cliente.toString());
        }
    }

    public void selectClient(Client cliente) {
        // Logica per selezionare un cliente
        System.out.println("Cliente selezionato: ");
        //Lazy initializzation
        Client_PT_Interface CPTI = new Client_PT_Interface(cliente, PT);
        CPTI.visualizza();
    }

    public void visualizzaRichieste() {
        // Logica per visualizzare le richieste dei clienti
        System.out.println("Visualizzando richieste per il PT: " + PT.getNome());
        BI.visualizza();
    }
}
