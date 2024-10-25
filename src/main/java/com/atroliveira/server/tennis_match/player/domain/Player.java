package com.atroliveira.server.tennis_match.player.domain;

import com.atroliveira.server.tennis_match.utils.validation.ValidationMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Player {

    private Integer id;
    @NotNull(message = "username "+ValidationMessage.NOT_NULL) //TODO improve the string binding
    @NotEmpty(message = "username "+ValidationMessage.NOT_EMPTY)
    private String username;
    @NotNull(message = "name" +ValidationMessage.NOT_NULL)
    @NotEmpty(message = "name "+ValidationMessage.NOT_EMPTY)
    private String name;
    private String surname;
    @NotNull(message = "age" +ValidationMessage.NOT_NULL)
    @Min(message = "Player cannot be under 18", value = 18)
    private Integer age;
    @JsonIgnore
    private boolean active;

    public Player(Integer id, String username, String name, String surname, Integer age, boolean active) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
