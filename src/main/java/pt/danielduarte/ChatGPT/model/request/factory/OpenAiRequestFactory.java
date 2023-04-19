package pt.danielduarte.ChatGPT.model.request.factory;

import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;
import pt.danielduarte.ChatGPT.modelo.Chat;

public class OpenAiRequestFactory {
    public static OpenAIRequest createChatOpenAiRequest(Chat chat){
        final OpenAIRequest req = new OpenAIRequest();

        req.setModel("text-davinci-003");
        req.setPrompt(chatPromptToString(chat)+ "\nAI:");
        req.setTemperature(0.5f);
        req.setMaxTokens(60);
        req.setTopP(1.0f);
        req.setFrequencyPenalty(0.5f);
        req.setPresencePenalty(0.5f);
        req.setStop(new String[]{"AI:"});

        return req;
    }

    private static String chatPromptToString(Chat chat){
        String result = chat.getPrompt();

        // result needs to be Subject:MessageContent \n...
        for(int i = 0 ; i < chat.getMessages().size(); i++){
            result = result + "\n" + chat.getMessages().get(i).toString();
        }
        return result;
    }
}

