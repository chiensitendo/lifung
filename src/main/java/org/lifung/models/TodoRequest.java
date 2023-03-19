package org.lifung.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoRequest {

    @JsonProperty
    private String title;
    @JsonProperty
    private String content;
    @JsonProperty
    private String note;
    @JsonProperty
    private Priority priority;

    public TodoRequest() {}
    public TodoRequest(String title, String content, String note, Priority priority) {
        this.title = title;
        this.content = content;
        this.note = note;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
