package com.atroliveira.server.tennis_match.match.infra;

import com.atroliveira.server.tennis_match.match.domain.Match;
import com.atroliveira.server.tennis_match.match.infra.datasource.MatchDTO;
import com.atroliveira.server.tennis_match.team.domain.Team;

public class MatchMapper {

    public Match transform(MatchDTO matchDTO, Team team1, Team team2) {
        return new Match(matchDTO.getId(), team1, team2, matchDTO.getWinnerTeamId(),
                matchDTO.getGames(), matchDTO.getSets(), matchDTO.getStartMatchDate(), matchDTO.getEndMatchDate());
    }
}

