package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;
import src.DB_Add.Add_Controller;
public class Client_PT_Interface {
    private Personal_Trainer PT;
    private Client client;
    private Add_Controller AC;
    Client_PT_Interface(Client cliente, Personal_Trainer PT){
        this.PT = PT;
        this.client = cliente;
    }


    public void visualizza() {
        // Logica per visualizzare i dettagli
        System.out.println("Fissa un appuntamento con il "+client.toString());
    }

    public void fissaAppuntamento(String orario, String type) {
        // Logica per fissare un appuntamento con il cliente selezionato
        if(AC.add_appuntamento(PT.getID(),client.getID(),orario,"P")){
            System.out.println("Appuntamento fissato con il" + client.toString());
        }else System.out.println("Appuntamento non fissato errore nel DB...");

    }
}
