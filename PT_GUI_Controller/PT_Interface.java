package PT_GUI_Controller;
import models.Personal_Trainer;

public class PT_Interface {
    private Personal_Trainer PT;

    public void visualizza_informazioni(){
        // Logica per visualizzare le informazioni -> Interfaccia informazioni
        Information_Interface II = new Information_Interface(PT);
        II.visualizza();

    }
    public void tabella_clienti(){
        // Logica per mostrare la tabella dei clienti -> Interfaccia clienti
    }
    public void recensioni(Object PT){
        // Logica per mostrare le recensioni del Personal Trainer -> Interfaccia recensioni
    }

    public void visualizza(){
        // Logica generica per la visualizzazione della pagina
    }
}
