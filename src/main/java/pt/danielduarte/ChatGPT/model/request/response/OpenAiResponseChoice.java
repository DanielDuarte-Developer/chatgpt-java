package pt.danielduarte.ChatGPT.model.request.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenAiResponseChoice {
    private String text;
    private int index;
    private Object logprobs;
    @JsonProperty("finish_reason")
    private String fisnishReason;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    public String getFisnishReason() {
        return fisnishReason;
    }

    public void setFisnishReason(String fisnishReason) {
        this.fisnishReason = fisnishReason;
    }
}
