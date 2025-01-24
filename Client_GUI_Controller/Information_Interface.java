package Client_GUI_Controller;
import models.Client;
import java.sql.ResultSet;
import src.DB_Visualizer.DB_Visualizer;
public class Information_Interface {
    private Client utente;
    private DB_Visualizer DB;
    private ResultSet RS;
    Information_Interface(Client utente){
        this.utente = utente;
    }
    public void visualizza(){
        System.out.println("Informazioni dell'utente:");
        getInformazioni();
    }
    public void getInformazioni(){
        //Restituisce informazioni in formato ResultSet dal DB
        System.out.println("Recuperando informazioni dal database...");
        DB.generateExecute(1, utente.getID());
        RS = DB.getResult();

        try{
            while(RS.next()){
                int ID = RS.getInt("U_ID");
                String nome = RS.getString("nome");
                String cognome = RS.getString("cognome");
                System.out.println("ID: "+ID+", Nome: "+nome+", Cognome: "+cognome);
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public void modifica_informazioni(){
        //Chiamata a interfaccia modifica info
        Modify_Interface MI =  new Modify_Interface(utente);
        MI.visualizza();
    }
}
