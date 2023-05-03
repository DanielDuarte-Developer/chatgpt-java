package pt.danielduarte.ChatGPT.service;

import pt.danielduarte.ChatGPT.client.OpenAiCompletionsClient;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;
import pt.danielduarte.ChatGPT.model.request.factory.OpenAiRequestFactory;
import pt.danielduarte.ChatGPT.model.request.modelo.Chat;
import pt.danielduarte.ChatGPT.model.request.modelo.Message;
import pt.danielduarte.ChatGPT.model.request.response.OpenAiResponse;
import pt.danielduarte.ChatGPT.model.request.response.OpenAiResponseChoice;

import java.io.IOException;
import java.util.List;

public class OpenAiChatService {

    private OpenAiRequestFactory openAiRequestFactory;
    private OpenAiCompletionsClient openAiCompletionsClient;

    public OpenAiChatService(OpenAiRequestFactory openAiRequestFactory, OpenAiCompletionsClient openAiCompletionsClient) {
        this.openAiRequestFactory = openAiRequestFactory;
        this.openAiCompletionsClient = openAiCompletionsClient;
    }

    public List<Message> sendMessage(Chat chat, String messageToSend) throws IOException {
        final Message message= new Message("Person",messageToSend);
        chat.addMessage(message);

        final OpenAIRequest request = openAiRequestFactory.createChatOpenAiRequest(chat);
        final OpenAiResponse response = openAiCompletionsClient.post(request);

        return response.getChoices().stream().map(OpenAiResponseChoice::getText)
                .map(textResponse -> new Message("AI",textResponse))
                .peek(chat::addMessage).toList();
    }
}

