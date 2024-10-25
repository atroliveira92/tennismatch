package com.atroliveira.server.tennis_match.player.domain;

import com.atroliveira.server.tennis_match.player.infra.PlayerRepository;
import com.atroliveira.server.tennis_match.utils.exception.NotUpdatedException;
import com.atroliveira.server.tennis_match.utils.exception.PlayerNotFoundException;
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
        Player player = playerRepository.getPlayerById(id);
        if (player == null)
            throw new PlayerNotFoundException("id " + id);

        return player;
    }

    public Player savePlayer(Player player) {
        //TODO add validations
        player.setActive(true);
        return playerRepository.savePlayer(player);
    }

    public Player updatePlayer(Player player) {
        Player playerFound = findPlayerById(player.getId());

        if (playerFound == null) throw new PlayerNotFoundException("id " + player.getId());

        playerFound.setName(player.getName());
        playerFound.setSurname(player.getSurname());
        playerFound.setAge(player.getAge());

        boolean updated = playerRepository.updatePlayer(playerFound);

        if (!updated) throw new NotUpdatedException(player.getId());

        return playerFound;
    }

    public void deactivatePlayer(int id) {
        if (findPlayerById(id) == null) throw new PlayerNotFoundException("id " + id);

        boolean updated = playerRepository.deactivatePlayer(id);

        if (!updated) throw new NotUpdatedException(id);
    }
}
