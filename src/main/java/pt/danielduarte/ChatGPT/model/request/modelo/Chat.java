package pt.danielduarte.ChatGPT.model.request.modelo;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final List<Message> messages;

    public Chat() {
        this.messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

}
