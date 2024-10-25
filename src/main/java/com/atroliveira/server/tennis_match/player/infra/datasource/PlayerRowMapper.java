package com.atroliveira.server.tennis_match.player.infra.datasource;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class PlayerRowMapper implements RowMapper<PlayerDTO> {
    @Override
    public PlayerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PlayerDTO(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getInt("age"),
                rs.getBoolean("active"));
    }
}
