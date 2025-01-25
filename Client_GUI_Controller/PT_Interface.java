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
    private List<Personal_Trainer> PT_listAssociati;
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
        //Restituisce i PT dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("I",3,utente.getID());
        return DB.getResult_list(); //Lista di tutti i personal trainer
    }
    public List<Personal_Trainer> getPTAssociati(){
        //Restituisce i PT associato all'utente
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute("C",3,utente.getID());
        return DB.getResult_list(); //Lista dei personal trainer associati all'utente
    }
    public void addReview(Personal_Trainer PT){
        //Chiamata a interfaccia recensioni
        Review_Interface RI = new Review_Interface(PT,utente);
        RI.visualizza();
    }
    public void visualizza(){
        //Classica logica per la visualizzazione
        PT_list = getPT();
        System.out.println("Lista di tutti i personal trainer della palestra: ");
        for(Personal_Trainer PT : PT_list){
            System.out.println(PT.toString());
        }
        PT_listAssociati = getPTAssociati();
        System.out.println("Lista di tutti i personal trainer associati a te : ");
        for(Personal_Trainer PT : PT_listAssociati){
            System.out.println(PT.toString());
        }
    }
}
