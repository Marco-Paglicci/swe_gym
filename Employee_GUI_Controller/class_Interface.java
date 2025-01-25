package Employee_GUI_Controller;
import models.Employee;
import models.Corso;
import src.DB_Visualizer.DB_Visualizer;
import src.DB_Add.Add_Controller;
import src.DB_Remove.Remove_Controller;
import java.sql.Time;
import java.util.List;

public class class_Interface {
    private Employee personale;
    private List<Corso> Corsi_List;
    private DB_Visualizer DB;
    private Add_Controller AC;
    private Remove_Controller RC;

    class_Interface(Employee personale){
        this.personale = personale;
    }
    public void add_class(int ID, String nome, Time durata, int iscritti){
        //Logica per aggiungere un corso
        Corso corso = new Corso(ID,nome,durata,iscritti);
        if(AC.add_corso(personale.getID(),corso,"I")){
            System.out.println("Aggiunta del corso andata a buon fine");
        }else System.out.println("Aggiunta del corso negata...");
    }
    public void remove_class(Corso corso){
        //Logica per rimuovere un corso
        if(RC.remove_corsi(personale.getID(), corso, "I")){
            System.out.println("Rimozione del corso avveuta con successo");
        }else System.out.println("Rimozione negata...");
    }

    public List<Corso> getCorsi(){
        DB.generateExecute("I",2,personale.getID());
        return DB.getResult_list(); //Lista di corsi
    }
    public void visualizza(){
        Corsi_List = getCorsi();
        for (Corso corso: Corsi_List) {
            System.out.println(corso.toString());
        }
    }

}
