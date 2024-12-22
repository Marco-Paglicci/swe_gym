package PT_GUI_Controller;
import models.Personal_Trainer;

public class Review_Interface {
    private Personal_Trainer PT;

    public void visualizza() {
        // Logica per visualizzare le recensioni
        System.out.println("Visualizzando recensioni per il PT: " + PT.getNome());
    }

    public Object getRecensione() {
        // Logica per ottenere una recensione
        System.out.println("Recuperando una recensione dal DB...");
        return null; // Placeholder
    }
}
