package com.atroliveira.server.tennis_match.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NotUpdatedException extends RuntimeException {

    public NotUpdatedException(int entityId) {
        super("Not able to update id "+entityId);
    }
}
