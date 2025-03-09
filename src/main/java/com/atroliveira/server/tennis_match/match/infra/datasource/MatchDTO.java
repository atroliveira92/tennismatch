package com.atroliveira.server.tennis_match.match.infra.datasource;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MatchDTO {
    private int id;
    private int teamId1;
    private int teamId2;
    private int winnerTeamId;
    private int games;
    private int sets;
    private LocalDateTime startMatchDate;
    private LocalDateTime endMatchDate;

    public MatchDTO(int id, int teamId1, int teamId2, int winnerTeamId, int games, int sets,
                    LocalDateTime startMatchDate, LocalDateTime endMatchDate) {
        this.id = id;
        this.teamId1 = teamId1;
        this.teamId2 = teamId2;
        this.winnerTeamId = winnerTeamId;
        this.games = games;
        this.sets = sets;
        this.startMatchDate = startMatchDate;
        this.endMatchDate = endMatchDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId1() {
        return teamId1;
    }

    public void setTeamId1(int teamId1) {
        this.teamId1 = teamId1;
    }

    public int getTeamId2() {
        return teamId2;
    }

    public void setTeamId2(int teamId2) {
        this.teamId2 = teamId2;
    }

    public int getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(int winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public LocalDateTime getStartMatchDate() {
        return startMatchDate;
    }

    public Timestamp getStartMatchDateTimeStamp() {
        if (startMatchDate != null)
            return Timestamp.valueOf(startMatchDate);
        return null;
    }

    public void setStartMatchDate(LocalDateTime startMatchDate) {
        this.startMatchDate = startMatchDate;
    }

    public LocalDateTime getEndMatchDate() {
        return endMatchDate;
    }

    public Timestamp getEndMatchDateTimeStamp() {
        if (endMatchDate != null)
            return Timestamp.valueOf(endMatchDate);
        return null;
    }

    public void setEndMatchDate(LocalDateTime endMatchDate) {
        this.endMatchDate = endMatchDate;
    }
}
