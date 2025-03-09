package com.atroliveira.server.tennis_match.team.infra.datasource;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class TeamRowMapper implements RowMapper<TeamDTO> {
    @Override
    public TeamDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TeamDTO(
            rs.getInt("id"),
            rs.getInt("player_id_1"),
            rs.getInt("player_id_2")
        );
    }
}
