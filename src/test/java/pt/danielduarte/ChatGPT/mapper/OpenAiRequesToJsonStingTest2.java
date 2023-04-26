package pt.danielduarte.ChatGPT.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.danielduarte.ChatGPT.model.request.OpenAIRequest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OpenAiRequesToJsonStingTest2 {
    private OpenAiRequesToJsonSting subject;
    private ObjectMapper objectMapperMock;

    @BeforeEach
    void setup(){
        this.objectMapperMock = Mockito.mock(ObjectMapper.class);
        this.subject = new OpenAiRequesToJsonSting(objectMapperMock);
    }

    @Test
    void testSucceed() throws JsonProcessingException {
        OpenAIRequest request = Mockito.mock(OpenAIRequest.class);

        String expectedResult = "MyExpectedResult";
        Mockito.when(this.objectMapperMock.writeValueAsString(request)).thenReturn(expectedResult);

        String result = this.subject.map(request);

        Mockito.verify(this.objectMapperMock,Mockito.times(1)).writeValueAsString(request);

        assertEquals(expectedResult, result);
    }

    @Test
    void testRunTimeException() throws JsonProcessingException {
        Exception mockedException = Mockito.mock(JsonProcessingException.class);
        Mockito.when(this.objectMapperMock.writeValueAsString(Mockito.any())).thenThrow(mockedException);

        assertThrows(RuntimeException.class, () ->{
            this.subject.map(new OpenAIRequest());
        }, "Excepted a RunTimeException to be throw when ObjectMapper Throws JsonProcessingException");
    }
}