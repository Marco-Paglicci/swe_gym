package PT_GUI_Controller;
import models.Personal_Trainer;
public class Modify_Interface {
    private Personal_Trainer PT;

    public void visualizza() {
        // Logica per visualizzare la modifica
        System.out.println("Visualizzando informazioni modificabili per il PT: " + PT.getNome());
    }

    public void modificaInformazioni(String nome, String cognome) {
        // Modifica i dati del Personal Trainer sul DB

        System.out.println("Informazioni aggiornate: " + PT.getNome() + " " + PT.getCognome());
    }
}
