package pt.danielduarte.ChatGPT;

import com.fasterxml.jackson.databind.ObjectMapper;
import pt.danielduarte.ChatGPT.client.OpenAiCompletionsClient;
import pt.danielduarte.ChatGPT.client.OpenAiResponseHandler;
import pt.danielduarte.ChatGPT.mapper.OpenAiRequesToJsonSting;
import pt.danielduarte.ChatGPT.model.request.modelo.Message;
import pt.danielduarte.ChatGPT.service.OpenAiChatService;
import pt.danielduarte.ChatGPT.model.request.factory.OpenAiRequestFactory;
import pt.danielduarte.ChatGPT.model.request.modelo.Chat;
import pt.danielduarte.ChatGPT.util.ConfigParser;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String TOKEN ="";

    public static void main(String[] args) throws IOException {
       final Scanner sc = new Scanner(System.in);
        Map<String,String> config = ConfigParser.parse("application.properties");
        String greeting = config.get("greeting");
        String token = config.get("token");
        Chat chat = new Chat();
        OpenAiRequestFactory openAiRequestFactory = new OpenAiRequestFactory();
        OpenAiCompletionsClient client = new OpenAiCompletionsClient(token,new OpenAiRequesToJsonSting(),new OpenAiResponseHandler(new ObjectMapper()));

        final OpenAiChatService service = new OpenAiChatService(openAiRequestFactory,client);

        while(true){
            System.out.println("Person: ");
            service.sendMessage(chat,sc.nextLine()).forEach(message -> System.out.printf("%s: %s\n", message.getSubject(), message.getContent()));
        }
    }
}
