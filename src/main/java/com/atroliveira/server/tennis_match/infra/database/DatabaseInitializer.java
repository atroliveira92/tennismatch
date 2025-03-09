package com.atroliveira.server.tennis_match.infra.database;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
       createPlayerTable();
       createTeamTable();
       createMatchTable();
    }

    private void createPlayerTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS player (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(50) NOT NULL,
                    name VARCHAR(50) NOT NULL,
                    surname VARCHAR(50),
                    age INT,
                    active BOOLEAN
                );
                """;

        jdbcTemplate.execute(sql);
        System.out.println("Table 'player' verified/created successfully.");
    }

    private void createTeamTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS team (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    player_id_1 INT NOT NULL,
                    player_id_2 INT,
                    CONSTRAINT fk_team_player1 FOREIGN KEY (player_id_1) REFERENCES player(id),
                    CONSTRAINT fk_team_player2 FOREIGN KEY (player_id_2) REFERENCES player(id)
                );
                """;

        jdbcTemplate.execute(sql);
        System.out.println("Table 'team' verified/created successfully.");
    }

    private void createMatchTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS team (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    team_id_1 INT NOT NULL,
                    team_id_2 INT NOT NULL,
                    winner_team_id INT,
                    games INT NOT NULL,
                    sets INT NOT NULL,
                    start_match_date DATETIME NOT NULL,
                    end_match_date DATETIME,
                    CONSTRAINT fk_match_team1 FOREIGN KEY (team_id_1) REFERENCES team(id),
                    CONSTRAINT fk_match_team2 FOREIGN KEY (team_id_2) REFERENCES team(id)
                );
                """;

        jdbcTemplate.execute(sql);
        System.out.println("Table 'match' verified/created successfully.");
    }
}

