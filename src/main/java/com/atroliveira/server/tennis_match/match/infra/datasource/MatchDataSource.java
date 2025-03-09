package com.atroliveira.server.tennis_match.match.infra.datasource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class MatchDataSource {

    private final JdbcTemplate jdbcTemplate;

    public MatchDataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MatchDTO getMatchById(int id) {
        String sql = "SELECT * FROM match WHERE id="+id;
        return jdbcTemplate
                .query(sql, new MatchRowMapper())
                .stream()
                .findFirst()
                .orElse(null);
    }

    public MatchDTO insertMatch(MatchDTO matchDTO) {
        String sql = "INSERT INTO match (team_id_1, team_id_2, winner_team_id, games, sets, start_match_date, end_match_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setInt(1, matchDTO.getTeamId1());
            ps.setInt(2, matchDTO.getTeamId2());
            ps.setInt(3, matchDTO.getWinnerTeamId());
            ps.setInt(4, matchDTO.getGames());
            ps.setInt(5, matchDTO.getSets());
            ps.setTimestamp(6, Timestamp.valueOf(matchDTO.getStartMatchDate()));
            ps.setTimestamp(7, Timestamp.valueOf(matchDTO.getEndMatchDate()));

            return ps;
        }, keyHolder);

        int generatedId = keyHolder.getKey().intValue();
        matchDTO.setId(generatedId);
        return matchDTO;
    }

    public boolean updateMatch(MatchDTO matchDTO) {
        String sql = "INSERT SET team_id_1 = ?, team_id_2 = ?, winner_team_id = ?, games = ?, sets = ?, start_match_date = ?, end_match_date = ? WHERE id =?";
        int rowAffected = jdbcTemplate.update(sql,
                matchDTO.getTeamId1(),
                matchDTO.getTeamId2(),
                matchDTO.getWinnerTeamId(),
                matchDTO.getGames(),
                matchDTO.getSets(),
                matchDTO.getStartMatchDateTimeStamp(),
                matchDTO.getEndMatchDateTimeStamp());

        return rowAffected >= 1;
    }
}
