package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;
public class Client_Interface {
    private Personal_Trainer PT;
    private Client[] clients;

    public Object[] getClienti() {
        // Logica per recuperare i clienti
        System.out.println("Recuperando clienti...");
        //-> Inserisce in clients
        return new Object[0];
    }

    public void visualizza() {
        // Logica per visualizzare i clienti
        System.out.println("Visualizzando clienti per il PT: " + PT.getNome());
    }

    public void selectClient(Object client) {
        // Logica per selezionare un cliente
        System.out.println("Cliente selezionato: " + client);

        //Una volta selezionato si può andare nella pagina appuntamenti
    }

    public void visualizzaRichieste(Personal_Trainer pt) {
        // Logica per visualizzare le richieste dei clienti
        System.out.println("Visualizzando richieste per il PT: " + pt.getNome());
        //Prese dal DB
    }
}
