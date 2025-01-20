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
    public void renewal_subsciption(int duration){
        //Logica per allungare la data di scadenza
        if(duration == 6 || duration==12) {
            expiration += duration; //abbonamento da 3 mesi ...

        }else
            System.out.println("Data specificata non uniforme, seleziona 6 o 12 mesi di rinnovo");

    }

}
