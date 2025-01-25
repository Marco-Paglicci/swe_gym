package models;

import java.sql.Date;
import java.time.LocalDate;

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

    public void renewal_subscription(int monthsToAdd) {
        if (expiration != null) {
            // Converti java.sql.Date in java.time.LocalDate
            LocalDate expirationLocalDate = expiration.toLocalDate();

            // Aggiungi i mesi
            expirationLocalDate = expirationLocalDate.plusMonths(monthsToAdd);

            // Converti LocalDate di nuovo in java.sql.Date
            expiration = Date.valueOf(expirationLocalDate);
        } else {
            System.err.println("Errore: la data di scadenza è null.");
        }
    }

    public boolean isSub_type() {
        return sub_type;
    }

    public Date getExpiration() {
        return expiration;
    }
}
