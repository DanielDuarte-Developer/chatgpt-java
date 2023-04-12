package pt.danielduarte.ChatGPT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;
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

        OpenAIRequest req = new OpenAIRequest();
        req.setModel("text-davinci-003");
        req.setPrompt("You are an AI\nAI:");
        req.setTemperature(0.5f);
        req.setMaxTokens(60);
        req.setTopP(1.0f);
        req.setFrequencyPenalty(0.5f);
        req.setPresencePenalty(0.5f);
        req.setStop(new String[]{"AI:"});

        ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = null;
        try {
            jsonPayload = mapper.writeValueAsString(req);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        System.out.println(jsonPayload);
    }
}
