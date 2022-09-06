package com.epam.movie_rating.service;


import com.epam.movie_rating.config.StoredProcedure;
import com.epam.movie_rating.model.Film;
import com.epam.movie_rating.repository.FilmRepository;
import com.epam.movie_rating.repository.UserFilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RatingService {

    private StoredProcedure storedProcedure;
    private final FilmRepository filmRepository;
    private final UserFilmRepository userFilmRepository;


    @Autowired
    public RatingService(UserFilmRepository userFilmRepository, FilmRepository filmRepository, StoredProcedure storedProcedure) {
        this.filmRepository = filmRepository;
        this.userFilmRepository = userFilmRepository;
        this.storedProcedure = storedProcedure;
    }

    public Film save(long filmId) {


        int rate = storedProcedure.start(filmId);

        Film film = filmRepository.findById(filmId).get();
        film.setRateAverage(rate);

//        film.setRateAverage(userFilmRepository.findByRate(filmId));
        filmRepository.save(film);
        return film;
    }
}
