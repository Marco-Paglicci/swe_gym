package Employee_GUI_Controller;
import models.Personal_Trainer;
import models.Employee;
import src.DB_Visualizer.DB_Visualizer;
import src.DB_Visualizer.PersonalTrainer_Strategy;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Interface_PT {
    private Personal_Trainer[] PT_list;
    private Employee personale;
    private DB_Visualizer DB;
    Interface_PT(Employee personale){
        this.personale = personale;
    }

    public void visualizza(){
        System.out.println("Pagine personale: "+personale.getNome());
        System.out.println("Logica per visualizzare la lista di tutti i PT");
        PT_list = getPT();
        for(Personal_Trainer PT : PT_list){
            System.out.println("Nome: "+ PT.getNome());
            System.out.println("Cognome: "+ PT.getCognome());
            System.out.println("ID: "+ PT.getID());
        }

    }
    public void  aggiungi_PT(Personal_Trainer PT){
        //TODO:restituisce true o false per l'operazione
    }
    public void rimuovi_PT( Personal_Trainer PT){

    }

    public Personal_Trainer[] getPT(){
        System.out.println("Recupero i persnal trainer disponibili dal DB...");
        DB.generateExecute(3,0);
        ResultSet RS = DB.getResult();

        List<Personal_Trainer> PTs = new ArrayList<>();
        try{
            while(RS.next()){
                Personal_Trainer PT = new Personal_Trainer(
                        RS.getInt("id"),
                        RS.getString("nome"),
                        RS.getString("cognome")
                );
                PTs.add(PT);
            }
        }catch(Exception e){e.printStackTrace();}
        return PTs.toArray(new Personal_Trainer[0]);
    }
}
