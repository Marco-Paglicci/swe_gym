package PT_GUI_Controller;
import models.Personal_Trainer;
import java.sql.ResultSet;
import src.DB_Visualizer.DB_Visualizer;

public class Information_Interface {
    private Personal_Trainer PT;
    private Modify_Interface MI;
    private DB_Visualizer DB;

    Information_Interface(Personal_Trainer PT){
        this.PT = PT;
        this.MI = new Modify_Interface(PT);
    }
    public void visualizza() {
        // Logica per visualizzare le informazioni del PT
        getInformazioni();
    }

    public void getInformazioni() {
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute();//TODO:metodo per informazioni di PT
        ResultSet RS = DB.getResult();

        try{
            while(RS.next()){
                int ID = RS.getInt("PT_ID");
                String nome = RS.getString("nome");
                String cognome = RS.getString("cognome");
                System.out.println("Informazioni\n");
                System.out.println("ID: "+ID+", nome: "+nome+", cognome: "+cognome);
            }

        }catch(Exception e){e.printStackTrace();}

    }

    public void modificaInformazioni() {
        // Logica per modificare le informazioni del Personal Trainer sul DB
        MI.visualizza();
    }
}
