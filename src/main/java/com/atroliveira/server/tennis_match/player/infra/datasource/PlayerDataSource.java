package com.atroliveira.server.tennis_match.player.infra.datasource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class PlayerDataSource {

    private final JdbcTemplate jdbcTemplate;

    //TODO CHANGE URGENTLY TO JPA, GOD TO MUCH BOILER PLATE
    public PlayerDataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PlayerDTO> getAllPlayers() {
        String sql = "SELECT * FROM player where active=true";
        return jdbcTemplate.query(sql, new PlayerRowMapper());
    }

    public PlayerDTO getPlayerById(int id) {
        String sql = "SELECT * FROM player where active=true AND id="+ id;
        List<PlayerDTO> players = jdbcTemplate.query(sql, new PlayerRowMapper());

        return players.stream().findFirst().orElse(null);
    }

    public PlayerDTO insertPlayer(PlayerDTO player) {
        String sql = "INSERT INTO player (username, name, surname, age, active) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setString(1, player.getUsername());
            ps.setString(2, player.getName());
            ps.setString(3, player.getSurname());
            ps.setInt(4, player.getAge());
            ps.setBoolean(5, player.isActive());
            return ps;
        }, keyHolder);

        // Recupera o ID gerado e o define no objeto Player
        int generatedId = keyHolder.getKey().intValue();
        player.setId(generatedId);

        return player;
    }

    public boolean updatePlayerActiveStatus(int id, boolean active) {
        String sql = "UPDATE player SET active = ? WHERE id = ?";
        int rowsUpdated = jdbcTemplate.update(sql, active, id);

        return rowsUpdated >= 1;
    }

    public boolean updatePlayer(PlayerDTO player) {
        String sql = "UPDATE player SET username = ?, name = ?, surname = ?, age = ?, active = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql,
                player.getUsername(),
                player.getName(),
                player.getSurname(),
                player.getAge(),
                player.isActive(),
                player.getId());

        return rowsAffected >= 1;
    }
}
