package PT_GUI_Controller;
import models.Personal_Trainer;
import src.DB_Modify.Modify_Controller;
public class Modify_Interface {
    private Personal_Trainer PT;
    private Modify_Controller MC;
    public Modify_Interface(Personal_Trainer PT){
        this.PT = PT;
    }
    public void visualizza() {
        // Logica per visualizzare la modifica
        System.out.println("Visualizzando informazioni modificabili per il PT: " + PT.getNome());
    }

    public void modificaInformazioni(String nome, String cognome) {
        // Modifica i dati del Personal Trainer sul DB
        if(MC.modifica_informazioni(PT.getID(),nome,cognome,"P")){
            System.out.println("Modifica avvenuta con successo");
        }else System.out.println("Modifica negata...");
    }
}
