package pt.danielduarte.ChatGPT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.danielduarte.ChatGPT.mapper.OpenAiRequesToJsonSting;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;
import pt.danielduarte.ChatGPT.model.request.factory.OpenAiRequestFactory;
import pt.danielduarte.ChatGPT.model.request.modelo.Chat;
import pt.danielduarte.ChatGPT.util.ConfigParser;

import java.io.IOException;
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

        OpenAiRequesToJsonSting mapper = new OpenAiRequesToJsonSting();
        String jsonPayload = mapper.map(req);

        System.out.println(jsonPayload);
    }
}
