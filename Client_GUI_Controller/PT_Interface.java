package Client_GUI_Controller;
import models.Client;
import models.Personal_Trainer;
import src.DB_Visualizer.DB_Visualizer;
import src.DB_Visualizer.PersonalTrainer_Strategy;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PT_Interface {
    private Client utente;
    private List<Personal_Trainer> PT_list;
    private DB_Visualizer DB;
    PT_Interface(Client utente){
        this.utente = utente;
    }
    public void sendMessage(){
        //chiamata a message interface per creare un nuovo messagio
        Message_Interface MI = new Message_Interface();
        MI.visualizza();
    }
    public List<Personal_Trainer> getPT(){
        //Restituisce i PT in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("C",3,utente.getID());
        List<Personal_Trainer> ptlist = DB.getPTlist();
        return ptlist;
    }
    public void addReview(int PT_ID){
        //Chiamata a interfaccia recensioni
        Review_Interface RI = new Review_Interface(PT_ID,utente);
        RI.visualizza();
    }
    public void visualizza(){
        //Classica logica per la visualizzazione
        PT_list = getPT();
        for(Personal_Trainer PT : PT_list){
            PT.toString();
        }
    }
}
