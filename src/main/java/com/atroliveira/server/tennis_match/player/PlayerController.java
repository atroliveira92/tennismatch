package com.atroliveira.server.tennis_match.player;


import com.atroliveira.server.tennis_match.player.domain.Player;
import com.atroliveira.server.tennis_match.player.domain.PlayerService;
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
        return service.findPlayerById(id);
    }

    @PostMapping(PLAYERS_PATH)
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        Player savedPlayer = service.savePlayer(player);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPlayer.getId())
                .toUri();

        //TODO maybe implement HATEOAS (associated links)
        //TODO return the recent created Player

        return ResponseEntity.created(location).build();
    }

    @PutMapping(PLAYERS_PATH + "/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") int id, @Valid @RequestBody Player player) {
        player.setId(id);

        Player playerUpdated = service.updatePlayer(player);

        return ResponseEntity.ok(playerUpdated);
    }

    @PatchMapping(PLAYERS_PATH + "/{id}/deactivate")
    public ResponseEntity<Void> deactivatePlayer(@PathVariable("id") int id) {
        service.deactivatePlayer(id);

        return ResponseEntity.ok().build();
    }
}
