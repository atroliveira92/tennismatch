package com.atroliveira.server.tennis_match.team.domain;

public class Team {

    private Integer id;
    private Integer player1Id;
    private Integer player2id;

    public Team(Integer id, Integer player1Id, Integer player2id) {
        this.id = id;
        this.player1Id = player1Id;
        this.player2id = player2id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(Integer player1Id) {
        this.player1Id = player1Id;
    }

    public Integer getPlayer2id() {
        return player2id;
    }

    public void setPlayer2id(Integer player2id) {
        this.player2id = player2id;
    }
}
