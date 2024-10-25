package com.atroliveira.server.tennis_match.player.domain;

import com.atroliveira.server.tennis_match.player.infra.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> listAllPlayers() {
        return playerRepository.getAllPlayers();
    }

    public Player findPlayerById(int id) {
        return playerRepository.getPlayerById(id);
    }

    public Player savePlayer(Player player) {
        //TODO add validations
        player.setActive(true);
        return playerRepository.savePlayer(player);
    }
}
