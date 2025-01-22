package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;
public class Client_Interface {
    private Personal_Trainer PT;
    private Client[] clients;

    public Object[] getClienti() {
        // Logica per recuperare i clienti
        System.out.println("Recuperando clienti..."); //TODO:Gli prende dal DB??
        //-> Inserisce in clients
        return new Object[0];
    }

    public void visualizza() {
        // Logica per visualizzare i clienti
        System.out.println("Visualizzando clienti per il PT: " + PT.getNome());
    }

    public void selectClient(Client cliente) {
        // Logica per selezionare un cliente
        System.out.println("Cliente selezionato: ");
        Client_PT_Interface CPTI = new Client_PT_Interface(cliente, PT);
        CPTI.visualizza();
        //Una volta selezionato si può andare nella pagina appuntamenti
    }

    public void visualizzaRichieste() {
        // Logica per visualizzare le richieste dei clienti
        System.out.println("Visualizzando richieste per il PT: " + PT.getNome());
        Book_Interface BI = new Book_Interface(PT);
        BI.visualizza();
    }
}
