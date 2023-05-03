package pt.danielduarte.ChatGPT.client;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import pt.danielduarte.ChatGPT.mapper.OpenAiRequesToJsonSting;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;
import pt.danielduarte.ChatGPT.model.request.response.OpenAiResponse;

import java.io.IOException;


public class OpenAiCompletionsClient {
    private final static String completionsUrl = "https://api.openai.com/v1/completions";
    private String token;
    private OpenAiRequesToJsonSting requesToJsonSting;

    private OpenAiResponseHandler responseHandler;

    public OpenAiCompletionsClient(String token, OpenAiRequesToJsonSting requesToJsonSting, OpenAiResponseHandler responseHandler) {
        this.token = token;
        this.requesToJsonSting = requesToJsonSting;
        this.responseHandler = responseHandler;
    }

    public OpenAiResponse post(OpenAIRequest prompt) throws IOException {
        final String jsonPayload = requesToJsonSting.map(prompt);
        final HttpPost httpPost = new HttpPost(jsonPayload);
        final HttpClient client = HttpClients.createDefault();
        return client.execute(httpPost,responseHandler);
    }

    private HttpPost createHttpPost(String payload){
        final HttpPost httpPost = new HttpPost(completionsUrl);
        final StringEntity entity = new StringEntity(payload);

        httpPost.setEntity(entity);
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Content-type","application/json");
        httpPost.setHeader("Authorization", String.format("Bearer %s", token));
        return httpPost;
    }
}
