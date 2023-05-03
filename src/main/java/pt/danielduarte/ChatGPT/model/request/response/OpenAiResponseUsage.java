package pt.danielduarte.ChatGPT.model.request.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenAiResponseUsage {
    @JsonProperty("prompt_tokens")
    private int prompTokens;

    @JsonProperty("completion_tokens")
    private int completionTokens;

    @JsonProperty("total_tokens")
    private int totalTokens;

    public int getPrompTokens() {
        return prompTokens;
    }

    public void setPrompTokens(int prompTokens) {
        this.prompTokens = prompTokens;
    }

    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }
}
