package com.atroliveira.server.tennis_match.match.infra;

import com.atroliveira.server.tennis_match.match.domain.Match;
import com.atroliveira.server.tennis_match.match.infra.datasource.MatchDTO;
import com.atroliveira.server.tennis_match.match.infra.datasource.MatchDataSource;
import com.atroliveira.server.tennis_match.team.domain.Team;
import com.atroliveira.server.tennis_match.team.infra.TeamMapper;
import com.atroliveira.server.tennis_match.team.infra.datasource.TeamDTO;
import com.atroliveira.server.tennis_match.team.infra.datasource.TeamDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchRepository {

    @Autowired
    private MatchDataSource matchDataSource;

    @Autowired
    private TeamDataSource teamDataSource;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private TeamMapper teamMapper;

    public Match getMatchById(int id) {
        MatchDTO matchDTO = matchDataSource.getMatchById(id);
        Team team1 = getTeamById(matchDTO.getTeamId1());
        Team team2 = getTeamById(matchDTO.getTeamId2());

        return matchMapper.transform(matchDTO, team1, team2);
    }

    public Match createMatch(Match match) {
        Team team1 = match.getTeam1();
        Team team2 = match.getTeam2();

        if (team1.getId() == null) {
            team1 = createTeam(match.getTeam1());
        }
        if (team2.getId() == null) {
            team2 = createTeam(match.getTeam2());
        }
        MatchDTO matchDTO = matchToDTO(match);

        return matchMapper.transform(matchDTO, team1, team2);
    }

    private Team createTeam(Team team) {
        TeamDTO teamDTO1 = teamDataSource.insertTeam(new TeamDTO(null, team.getPlayer1Id(), team.getPlayer2id()));
        return teamMapper.transform(teamDTO1);
    }

    private Team getTeamById(int id) {
        TeamDTO teamDTO = teamDataSource.getTeamById(id);

        return teamMapper.transform(teamDTO);
    }

    private MatchDTO matchToDTO(Match match) {
        return new MatchDTO(
            match.getId(),
            match.getTeam1().getId(),
            match.getTeam2().getId(),
            match.getWinnerTeamId(),
            match.getGames(),
            match.getSets(),
            match.getStartMatchDate(),
            match.getEndMatchDate()
        );
    }

}
