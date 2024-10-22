package com.atroliveira.server.tennis_match.player;

public record Player(
    Integer id,
    String username,
    String name,
    String surname,
    Integer age,
    boolean active
) {}
