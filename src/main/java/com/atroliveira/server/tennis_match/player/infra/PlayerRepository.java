package com.atroliveira.server.tennis_match.player.infra;

import com.atroliveira.server.tennis_match.player.domain.Player;
import com.atroliveira.server.tennis_match.player.infra.datasource.PlayerDTO;
import com.atroliveira.server.tennis_match.player.infra.datasource.PlayerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {

    @Autowired
    private PlayerDataSource dataSource;

    @Autowired
    private PlayerMapper mapper;

    public List<Player> getAllPlayers() {
        return dataSource.getAllPlayers().stream().map(p -> mapper.map(p)).toList();
    }

    public Player getPlayerById(int id) {
        PlayerDTO playerDTO = dataSource.getPlayerById(id);

        if (playerDTO == null) return null;

        return mapper.map(playerDTO);
    }

    public Player savePlayer(Player player) {
        PlayerDTO playerDTO = new PlayerDTO(
                player.getId(),
                player.getUsername(),
                player.getName(),
                player.getSurname(),
                player.getAge(),
                player.isActive());

        playerDTO = dataSource.insertPlayer(playerDTO);

        return mapper.map(playerDTO);
    }
}
