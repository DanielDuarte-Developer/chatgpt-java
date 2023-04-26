package pt.danielduarte.ChatGPT.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;

public class OpenAiRequesToJsonSting {
    private final ObjectMapper mapper;

    public OpenAiRequesToJsonSting() {
        mapper = new ObjectMapper();
    }

    public OpenAiRequesToJsonSting(ObjectMapper mapper){
        this.mapper = mapper;
    }
    public String map(OpenAIRequest request){
        String jsonPayload = null;
        try {
            jsonPayload = mapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
        return jsonPayload;
    }
}
