package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;
public class Client_PT_Interface {
    private Personal_Trainer PT;
    private Client client;

    public Object getCliente() {
        //TODO:riguardare
        return client;
    }

    public void visualizza() {
        // Logica per visualizzare i dettagli
        System.out.println("Visualizzando dettagli...");
    }

    public void fissaAppuntamento() {
        // Logica per fissare un appuntamento con il cliente selezionato
        System.out.println("Appuntamento fissato con il cliente." + client.getID());
    }
}
