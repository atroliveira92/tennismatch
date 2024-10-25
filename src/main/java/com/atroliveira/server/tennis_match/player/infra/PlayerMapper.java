package com.atroliveira.server.tennis_match.player.infra;

import com.atroliveira.server.tennis_match.player.domain.Player;
import com.atroliveira.server.tennis_match.player.infra.datasource.PlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public Player map(PlayerDTO playerDTO) {
        return new Player(
                playerDTO.getId(),
                playerDTO.getUsername(),
                playerDTO.getName(),
                playerDTO.getSurname(),
                playerDTO.getAge(),
                playerDTO.isActive());
    }
}
