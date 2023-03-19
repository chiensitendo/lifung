package org.lifung.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoItem {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String title;
    @JsonProperty
    private String content;
    @JsonProperty
    private String note;
    @JsonProperty
    private Priority priority;
    @JsonProperty
    private Long ownerId;
    @JsonProperty
    private Status status;

    public ToDoItem() {}
    public ToDoItem(Long id, String title, String content, String note, Priority priority, Long ownerId, Status status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.note = note;
        this.priority = priority;
        this.ownerId = ownerId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
