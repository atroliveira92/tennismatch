package com.atroliveira.server.tennis_match.player.infra.datasource;

public class PlayerDTO {

    private Integer id;
    private String username;
    private String name;
    private String surname;
    private Integer age;
    private boolean active;

    public PlayerDTO(Integer id, String username, String name, String surname, Integer age, boolean active) {
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
