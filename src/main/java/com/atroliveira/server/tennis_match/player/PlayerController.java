package com.atroliveira.server.tennis_match.player;


import com.atroliveira.server.tennis_match.player.domain.Player;
import com.atroliveira.server.tennis_match.player.domain.PlayerService;
import com.atroliveira.server.tennis_match.utils.exception.PlayerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PlayerController {
    private static final String PLAYERS_PATH = "/players";

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping(PLAYERS_PATH)
    public List<Player> retrieveAllPlayers() {
        return service.listAllPlayers();
    }

    @GetMapping(PLAYERS_PATH + "/{id}")
    public Player retrievePlayerById(@PathVariable("id") int id) {
        Player player = service.findPlayerById(id);

        if (player == null)
            throw new PlayerNotFoundException("id " + id);

        return player;
    }

    @PostMapping(PLAYERS_PATH)
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        Player savedPlayer = service.savePlayer(player);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPlayer.getId())
                .toUri();

        //TODO maybe implement HATEOAS (associated links)

        return ResponseEntity.created(location).build();
    }
}
