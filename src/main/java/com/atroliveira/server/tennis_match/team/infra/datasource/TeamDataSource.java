package com.atroliveira.server.tennis_match.team.infra.datasource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;

public class TeamDataSource {

    private final JdbcTemplate jdbcTemplate;

    public TeamDataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TeamDTO getTeamById(int teamId) {
        String sql = "SELECT * FROM team where id=" + teamId;
        return jdbcTemplate
                .query(sql, new TeamRowMapper())
                .stream()
                .findFirst()
                .orElse(null);
    }

    public TeamDTO getTeamByPlayerId(int playerId) {
        String sql = "SELECT * FROM team where player_id_1 = " + playerId;
        return jdbcTemplate
                .query(sql, new TeamRowMapper())
                .stream()
                .findFirst()
                .orElse(null);
    }

    public TeamDTO getTeamByPlayers(int playerId1, int playerId2) {
        String sql = "SELECT * FROM team where player_id_1 = " + playerId1 + " and player_id_2" + playerId2;
        return jdbcTemplate
                .query(sql, new TeamRowMapper())
                .stream()
                .findFirst()
                .orElse(null);
    }

    public TeamDTO insertTeam(TeamDTO teamDTO) {
        String sql = "INSERT INTO team (player_id_1, player_id_2) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setInt(1, teamDTO.getPlayer1Id());
            ps.setInt(2, teamDTO.getPlayer2Id());
            return ps;
        }, keyHolder);

        int generatedId = keyHolder.getKey().intValue();
        teamDTO.setId(generatedId);
        return teamDTO;
    }
}
