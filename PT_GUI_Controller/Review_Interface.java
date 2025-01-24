package PT_GUI_Controller;
import models.Personal_Trainer;
import src.DB_Visualizer.DB_Visualizer;
import java.sql.ResultSet;
import java.util.List;

public class Review_Interface {
    private Personal_Trainer PT;
    private DB_Visualizer DB;
    private List<String> recensioni;
    private List<Integer> valutazioni;

    public Review_Interface(Personal_Trainer PT){
        this.PT = PT;
    }
    public void visualizza() {
        // Logica per visualizzare le recensioni
        System.out.println("Visualizzando recensioni per il PT: " + PT.getNome());
        recensioni = getRecensioni();
        for(String recensione: recensioni){
            System.out.println(recensione);
        }
        System.out.println("Visualizzando valutazioni per il PT: " + PT.getNome());
        valutazioni = getValutazioni();
        for(Integer valutazione: valutazioni){
            System.out.println(valutazione);
        }
    }

    public List<Integer> getValutazioni(){
        System.out.println("Recuperando valutazioni dal DB...");
        DB.generateExecute("P",6, PT.getID());//TODO: non c'è per le recensioni
        List<Integer> val = DB.getValutazioni();
        return val;
    }
    public List<String> getRecensioni() {
        // Logica per ottenere una recensione
        System.out.println("Recuperando recensioni dal DB...");
        DB.generateExecute("P",6, PT.getID());
        List<String> rec = DB.getRecensioni();
        return rec;
    }
}
