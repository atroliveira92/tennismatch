package com.atroliveira.server.tennis_match.match.domain;

import com.atroliveira.server.tennis_match.team.domain.Team;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Match {

    private int id;
    @NotNull(message = "You must provide the fist team")
    private Team team1;
    @NotNull(message = "You must provide the second team")
    private Team team2;
    private int winnerTeamId;
    @NotNull(message = "You must provide how much games")
    private int games;
    @NotNull(message = "You must provide how much sets")
    private int sets;
    @NotNull(message = "You must provide the start date")
    private LocalDateTime startMatchDate;
    private LocalDateTime endMatchDate;

    public Match(int id, Team team1, Team team2, int winnerTeamId, int games, int sets, LocalDateTime startMatchDate, LocalDateTime endMatchDate) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.winnerTeamId = winnerTeamId;
        this.games = games;
        this.sets = sets;
        this.startMatchDate = startMatchDate;
        this.endMatchDate = endMatchDate;
    }

    public int getId() {
        return id;
    }

    public @NotNull(message = "You must provide the fist team") Team getTeam1() {
        return team1;
    }

    public @NotNull(message = "You must provide the second team") Team getTeam2() {
        return team2;
    }

    public int getWinnerTeamId() {
        return winnerTeamId;
    }

    @NotNull(message = "You must provide how much games")
    public int getGames() {
        return games;
    }

    @NotNull(message = "You must provide how much sets")
    public int getSets() {
        return sets;
    }

    public @NotNull(message = "You must provide the start date") LocalDateTime getStartMatchDate() {
        return startMatchDate;
    }

    public LocalDateTime getEndMatchDate() {
        return endMatchDate;
    }

    public void setTeam1(@NotNull(message = "You must provide the fist team") Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(@NotNull(message = "You must provide the second team") Team team2) {
        this.team2 = team2;
    }

    public void setWinnerTeamId(int winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }
}
