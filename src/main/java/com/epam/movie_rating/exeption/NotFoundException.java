package com.epam.movie_rating.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }


}
