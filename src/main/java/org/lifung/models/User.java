package org.lifung.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;

    public User() {}
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
