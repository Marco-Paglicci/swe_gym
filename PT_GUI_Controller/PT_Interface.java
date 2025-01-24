package PT_GUI_Controller;
import models.Personal_Trainer;

public class PT_Interface {
    private Personal_Trainer PT;
    Information_Interface II;
    Client_Interface CI;
    Review_Interface RI;
    public PT_Interface(Personal_Trainer PT){
        this.PT = PT;
        this.II = new Information_Interface(PT);
        this.CI = new Client_Interface(PT);
        this.RI = new Review_Interface(PT);

    }

    public void visualizza_informazioni(){
        // Logica per visualizzare le informazioni -> Interfaccia informazioni
        II.visualizza();
    }
    public void tabella_clienti(){
        // Logica per mostrare la tabella dei clienti -> Interfaccia clienti
        CI.visualizza();
    }
    public void recensioni(Object PT){
        // Logica per mostrare le recensioni del Personal Trainer -> Interfaccia recensioni
        RI.visualizza();
    }

    public void visualizza(){
        // Logica generica per la visualizzazione della pagina
        System.out.println("Opzioni disponibili: ");
        System.out.println("1. Tabella clienti");
        System.out.println("2. Recensioni");
        System.out.println("3. Visualizza informazioni");
    }
}
