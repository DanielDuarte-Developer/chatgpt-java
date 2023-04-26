package pt.danielduarte.ChatGPT.model.request.factory;

import org.junit.jupiter.api.Test;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;
import pt.danielduarte.ChatGPT.model.request.modelo.Chat;
import pt.danielduarte.ChatGPT.model.request.modelo.Message;

import static org.junit.jupiter.api.Assertions.*;

class OpenAiRequestFactoryTest {

    private final OpenAiRequestFactory subject = new OpenAiRequestFactory();

    @Test
    void createChatOpenAiRequest() {
        Chat chat = new Chat("test prompt");
        chat.addMessage(new Message("AI", "Hello Human"));

        final OpenAIRequest result = subject.createChatOpenAiRequest(chat);

        assertEquals("text-davinci-003",result.getModel());
        assertEquals(0.5f, result.getTemperature());
        assertEquals(1.0f, result.getTopP());
        assertEquals(0.5f, result.getFrequencyPenalty());
        assertEquals(0.5f, result.getPresencePenalty());
        assertNotNull(result.getStop());
        assertEquals(1 , result.getStop().length);
        assertEquals("AI:", result.getStop()[0]);

        assertEquals("test prompt\nAI:Hello Human\nAI:",result.getPrompt());
    }
}