package models;

public class Message {
    private int sender;
    private int receiver;
    private String content;

    public Message(int mittente, int destinatario, String messaggio){
        this.sender = mittente;
        this.receiver = destinatario;
        this.content = messaggio;
    }
    public int getSender() {
        return sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }
}
