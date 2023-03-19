package org.lifung.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TodoListResponse {

    @JsonProperty
    List<ToDoItem> items;

    public TodoListResponse() {}
    public TodoListResponse(List<ToDoItem> items) {
        this.items = items;
    }

    public List<ToDoItem> getItems() {
        return items;
    }

    public void setItems(List<ToDoItem> items) {
        this.items = items;
    }
}
