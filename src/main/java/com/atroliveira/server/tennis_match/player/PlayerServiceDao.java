package com.atroliveira.server.tennis_match.player;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlayerServiceDao {

    private static List<Player> players = new ArrayList<>();

    static {
        players.add(new Player(1, "atroliveira", "Arthur", "Oliveira", 32, true));
        players.add(new Player(2, "arielv", "Ariel", "Vinicius", 32, true));
    }

    List<Player> findAll() {
        return players;
    }

    Player findPlayerById(int id) {
        return players.stream().filter(p -> p.id().equals(id)).findFirst().orElse(null);
    }

    Player insertPlayer(Player player) {
        players.add(player);
        return player;
    }
}
