package com.atroliveira.server.tennis_match.player;


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

    private PlayerServiceDao serviceDao;

    public PlayerController(PlayerServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    @GetMapping(PLAYERS_PATH)
    public List<Player> retrieveAllPlayers() {
        return serviceDao.findAll();
    }

    @GetMapping(PLAYERS_PATH + "/{id}")
    public Player retrievePlayerById(@PathVariable int id) {
        Player player = serviceDao.findPlayerById(id);

        if (player == null)
            throw new PlayerNotFoundException("id " + id);

        return player;
    }

    @PostMapping(PLAYERS_PATH)
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        Player savedPlayer = serviceDao.insertPlayer(player);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPlayer.id())
                .toUri();

        //TODO maybe implement HATEOAS

        return ResponseEntity.created(location).build();
    }
}
