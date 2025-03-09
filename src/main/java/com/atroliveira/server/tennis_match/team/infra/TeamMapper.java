package com.atroliveira.server.tennis_match.team.infra;

import com.atroliveira.server.tennis_match.team.domain.Team;
import com.atroliveira.server.tennis_match.team.infra.datasource.TeamDTO;

public class TeamMapper {

    public Team transform(TeamDTO teamDTO) {
        return new Team(teamDTO.getId(), teamDTO.getPlayer1Id(), teamDTO.getPlayer2Id());
    }
}
