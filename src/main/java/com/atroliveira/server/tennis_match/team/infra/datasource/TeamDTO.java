package com.atroliveira.server.tennis_match.team.infra.datasource;

public class TeamDTO {

    private Integer id;
    private Integer player1Id;
    private Integer player2Id;

    public TeamDTO(Integer id, Integer player1Id, Integer player2Id) {
        this.id = id;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
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

    public Integer getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(Integer player2Id) {
        this.player2Id = player2Id;
    }
}
