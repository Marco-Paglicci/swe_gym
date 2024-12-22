package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;
public class Book_Interface {
    private Personal_Trainer PT;
    private Client client;

    public void setCliente(Client client) {
        this.client = client;
        //La funzione passa il cliente selezionato alla classe
    }
    public void visualizza() {
        // Logica per visualizzare gli appuntamenti di un personal trainer con un cliente
        System.out.println("Visualizzazione degli appuntamenti per il PT: " + PT.getID() +
                " e il cliente: " + client.getID());
    }

    public void accept() {
        // Logica per accettare un appuntamento
        System.out.println("Appuntamento accettato tra PT: " + PT.getID() +
                " e cliente: " + client.getID());
    }

    public void refuse() {
        // Logica per rifiutare un appuntamento
        System.out.println("Appuntamento rifiutato tra PT: " + PT.getID() +
                " e cliente: " + client.getID());
    }
}
