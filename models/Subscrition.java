package models;

import java.sql.Date;

public class Subscrition {
    private boolean sub_type;
    private Date expiration;

    //Ctor


    public Subscrition(boolean sub_type, Date expiration) {
        this.sub_type = sub_type;
        this.expiration = expiration;
    }

    public void view_Subscription(){
        //Logica per visualizzare il tipo di abbonamento
        System.out.println("Abbonamento: "+sub_type+" Scadenza: "+expiration);
    }
    public void renewal_subsciption(){
        //Logica per allungare la data di scadenza   //todo fix with date type variables
        expiration += 6; //abbonamento da 3 mesi ... //TODO: si può rinnovare da 6 a 12 mesi

    }

}
