package com.atroliveira.server.tennis_match.player;

import com.atroliveira.server.tennis_match.utils.validation.ValidationMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record Player(
    Integer id,
    @NotNull(message = "username "+ValidationMessage.NOT_NULL) //TODO improve the string binding
    @NotEmpty(message = "username "+ValidationMessage.NOT_EMPTY)
    String username,
    @NotNull(message = "name" +ValidationMessage.NOT_NULL)
    @NotEmpty(message = "name "+ValidationMessage.NOT_EMPTY)
    String name,
    String surname,
    @NotNull(message = "age" +ValidationMessage.NOT_NULL)
    @Min(message = "Player cannot be under 18", value = 18)
    Integer age,
    @JsonIgnore
    boolean active
) {}
