package pt.danielduarte.ChatGPT.model.request.modelo;

public class Message {
    private String subject;
    private String content;

    public Message(){

    }

    public Message(String subject, String content){
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return subject + ":" + content;
    }
}
