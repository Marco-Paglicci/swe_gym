package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;
import src.DB_Visualizer.DB_Visualizer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Book_Interface {
    private Personal_Trainer PT;
    private List<Client> bookedC_list;
    private DB_Visualizer DB;

    Book_Interface(Personal_Trainer PT){
        this.PT = PT;
    }
    public void visualizza() {
        // Logica per visualizzare gli appuntamenti di un personal trainer con un cliente
        bookedC_list = getClientBooked();
        System.out.println("Visualizzazione degli appuntamenti per il PT: " + PT.getID());

        for(Client cliente : bookedC_list){
            System.out.println(cliente.toString());
        }

    }
    public List<Client> getClientBooked(){
        DB.generateExecute("P",4,PT.getID());
        return DB.getResult_list();//Lista degli appuntamenti che il personale trainer ha fissato
    }
    public void accept(Client client) {
        // Logica per accettare un appuntamento
        System.out.println("Appuntamento accettato tra PT: " + PT.getID() +
                " e cliente: " + client.getID());
        //TODO:inverà un messaggio all'utente con scritto il PT ha acceatto/rifuitato la tua richiesta
    }

    public void refuse(Client client) {
        // Logica per rifiutare un appuntamento
        System.out.println("Appuntamento rifiutato tra PT: " + PT.getID() +
                " e cliente: " + client.getID());
    }
}
