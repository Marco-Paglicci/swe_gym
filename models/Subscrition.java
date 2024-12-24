package models;

public class Subscrition {
    private String sub_type;
    private int expiration;

    //Ctor


    public Subscrition(String sub_type, int expiration) {
        this.sub_type = sub_type;
        this.expiration = expiration;
    }

    public void view_Subscription(){
        //Logica per visualizzare il tipo di abbonamento
        System.out.println("Abbonamento: "+sub_type+" Scadenza: "+expiration);
    }
    public void renewal_subsciption(){
        //Logica per allungare la data di scadenza
        expiration += 6; //abbonamento da 3 mesi ... //TODO: si può rinnovare da 6 a 12 mesi

    }

}
