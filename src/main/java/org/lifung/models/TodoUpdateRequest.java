package org.lifung.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoUpdateRequest {

    @JsonProperty
    private String title;
    @JsonProperty
    private String content;
    @JsonProperty
    private String note;
    @JsonProperty
    private Priority priority;
    @JsonProperty
    private Status status;
    public TodoUpdateRequest() {

    }

    public TodoUpdateRequest(String title, String content, String note, Priority priority, Status status) {
        this.title = title;
        this.content = content;
        this.note = note;
        this.priority = priority;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
