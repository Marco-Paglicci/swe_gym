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
    private Personal_Trainer[] PT_list;
    private DB_Visualizer DB;
    PT_Interface(Client utente){
        this.utente = utente;
    }
    public boolean sendMessage(){
        //chiamata a message interface per creare un nuovo messagio
        return true;
    }
    public Personal_Trainer[] getPT(){
        //Restituisce i PT in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute(3,utente.getID());
        ResultSet RS = DB.getResult();

        List<Personal_Trainer> PTs = new ArrayList<>();

        try{
            while(RS.next()){
                Personal_Trainer PT = new Personal_Trainer(
                        RS.getInt("PT_ID"),
                        RS.getString("nome"),
                        RS.getString("cognome")
                );
                PTs.add(PT);
            }
        }catch(Exception e){e.printStackTrace();}

        return PTs.toArray(new Personal_Trainer[0]);
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
