package com.epam.movie_rating.repository;


import com.epam.movie_rating.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {


}
