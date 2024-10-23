package com.atroliveira.server.tennis_match.utils.exception;

import java.time.LocalDate;

public record ErrorDetails(
    LocalDate timestamp,
    String message,
    String details
) {}
