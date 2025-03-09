package com.atroliveira.server.tennis_match.match.infra.datasource;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MatchRowMapper implements RowMapper<MatchDTO> {
    @Override
    public MatchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new MatchDTO(
            rs.getInt("id"),
            rs.getInt("team_id_1"),
            rs.getInt("team_id_2"),
            rs.getInt("winner_team_id"),
            rs.getInt("games"),
            rs.getInt("sets"),
            rs.getObject("start_match_date", LocalDateTime.class),
            rs.getObject("end_match_date", LocalDateTime.class)
        );
    }
}
