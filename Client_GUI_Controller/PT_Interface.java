package Client_GUI_Controller;
import java.sql.ResultSet;

public class PT_Interface {
    public boolean sendMessage(){
        //chiamata a message interface per creare un nuovo messagio
        return true;
    }
    public ResultSet getPT(){
        //Restituisce i PT in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        return null;
    }
    public void addReview(){
        //Chiamata a interfaccia recensioni
    }
    public void visualizza(){
        //Classica logica per la visualizzazione
    }
}
