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
        System.out.println("Tabela 'player' verificada/criada com sucesso.");
    }
}

