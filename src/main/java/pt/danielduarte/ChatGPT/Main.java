package pt.danielduarte.ChatGPT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.danielduarte.ChatGPT.client.OpenAiCompletionsClient;
import pt.danielduarte.ChatGPT.client.OpenAiResponseHandler;
import pt.danielduarte.ChatGPT.mapper.OpenAiRequesToJsonSting;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;
import pt.danielduarte.ChatGPT.model.request.factory.OpenAiRequestFactory;
import pt.danielduarte.ChatGPT.model.request.modelo.Chat;
import pt.danielduarte.ChatGPT.model.request.response.OpenAiResponse;
import pt.danielduarte.ChatGPT.model.request.response.OpenAiResponseChoice;
import pt.danielduarte.ChatGPT.util.ConfigParser;

import java.io.IOException;
import java.util.Map;

public class Main {
    private static final String TOKEN ="";

    public static void main(String[] args) throws IOException {

        Map<String,String> config = ConfigParser.parse("application.properties");
        String greeting = config.get("greeting");
        String token = config.get("token");
        System.out.println(greeting);

        OpenAiRequestFactory openAiRequestFactory = new OpenAiRequestFactory();
        Chat chat = new Chat(greeting);
        OpenAIRequest req = openAiRequestFactory.createChatOpenAiRequest(chat);

        OpenAiRequesToJsonSting mapper = new OpenAiRequesToJsonSting();
        OpenAiResponseHandler responseHandler = new OpenAiResponseHandler(new ObjectMapper());

        OpenAiCompletionsClient client = new OpenAiCompletionsClient(token,mapper,responseHandler);
        OpenAiResponse response = client.post(req);

       response.getChoices().stream().map(OpenAiResponseChoice::getText).forEach(System.out::println);
    }
}
