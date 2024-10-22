package com.atroliveira.server.tennis_match.player;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        return serviceDao.findPlayerById(id).get();
    }
}
