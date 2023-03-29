package pt.danielduarte.ChatGPT.modelo;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private String prompt;
    private List<Message> messages;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message){
        if(message == null){
            this.messages = new ArrayList<>();
        }
        this.messages.add(message);
    }
}
