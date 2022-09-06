package com.epam.movie_rating.endpoint;

import com.epam.movie_rating.model.Film;
import com.epam.movie_rating.service.RatingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rating")
@AllArgsConstructor
public class RatingController {

    private RatingService ratingService;

    @GetMapping("")
    public ResponseEntity<Film> getRate(@RequestParam long filmId) {
        return  ResponseEntity.ok(ratingService.save(filmId));
    }
}
