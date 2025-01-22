package PT_GUI_Controller;
import models.Personal_Trainer;
import models.Client;

public class Book_Interface {
    private Personal_Trainer PT;


    Book_Interface(Personal_Trainer PT){
        this.PT = PT;

    }
    public void visualizza() {
        // Logica per visualizzare gli appuntamenti di un personal trainer con un cliente
        //TODO:Prendere la lista dei clienti orenotati e visualizzarla

        System.out.println("Visualizzazione degli appuntamenti per il PT: " + PT.getID());
    }

    public void accept(Client client) {
        // Logica per accettare un appuntamento
        System.out.println("Appuntamento accettato tra PT: " + PT.getID() +
                " e cliente: " + client.getID());
    }

    public void refuse(Client client) {
        // Logica per rifiutare un appuntamento
        System.out.println("Appuntamento rifiutato tra PT: " + PT.getID() +
                " e cliente: " + client.getID());
    }
}
