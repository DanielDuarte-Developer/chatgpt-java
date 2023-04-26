package pt.danielduarte.ChatGPT.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;

import static org.junit.jupiter.api.Assertions.*;

class OpenAiRequesToJsonStingTest {
    private OpenAIRequest expectedRequest = new OpenAIRequest();

    class DummyMapper extends ObjectMapper{
        @Override
        public String writeValueAsString(Object value) throws JsonProcessingException {
            if(value != expectedRequest){
                throw new AssertionError("Unexpected value");
            }
            return "dummy";
        }
    }

    @BeforeEach
    void setUp(){

    }

    @Test
    void testMap() {
        OpenAiRequesToJsonSting subject = new OpenAiRequesToJsonSting(new DummyMapper());
        String result = subject.map(expectedRequest);

        assertEquals("dummy", result);
    }
}