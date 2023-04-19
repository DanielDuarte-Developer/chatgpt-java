package pt.danielduarte.ChatGPT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;
import pt.danielduarte.ChatGPT.model.request.factory.OpenAiRequestFactory;
import pt.danielduarte.ChatGPT.modelo.Chat;
import pt.danielduarte.ChatGPT.util.ConfigParser;
import pt.danielduarte.ChatGPT.util.FileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String TOKEN ="";

    public static void main(String[] args) throws IOException {

        Map<String,String> config = ConfigParser.parse("application.properties");
        String greeting = config.get("greeting");
        System.out.println(greeting);

        OpenAiRequestFactory openAiRequestFactory = new OpenAiRequestFactory();
        Chat chat = new Chat(greeting);
        OpenAIRequest req = openAiRequestFactory.createChatOpenAiRequest(chat);

        ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = null;
        try {
            jsonPayload = mapper.writeValueAsString(req);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            return;
            //throw new RuntimeException("Error: " + e.getMessage());
        }

        System.out.println(jsonPayload);
    }
}
