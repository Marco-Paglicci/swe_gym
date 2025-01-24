package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;
public class Client_PT_Interface {
    private Personal_Trainer PT;
    private Client client;
    Client_PT_Interface(Client cliente, Personal_Trainer PT){
        this.PT = PT;
        this.client = cliente;
    }
    //TODO: nell'uml c'era una getclienti abbastanza inutile

    public void visualizza() {
        // Logica per visualizzare i dettagli
        System.out.println("Fissa un appuntamento con il "+client.toString());
    }

    public void fissaAppuntamento(int data, int orario, String type) {
        // Logica per fissare un appuntamento con il cliente selezionato
        //TODO: magari qua mandiamo una notifica al cliente che ha un appuntamento fissato in quel giorno e orario ??
        System.out.println("Appuntamento fissato con il" + client.toString());
    }
}
