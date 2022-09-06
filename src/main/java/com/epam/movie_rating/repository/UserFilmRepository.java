package com.epam.movie_rating.repository;


import com.epam.movie_rating.model.UserFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserFilmRepository extends JpaRepository<UserFilm, Long> {
//    @Query(value = "CALL rateaverage(:id);", nativeQuery = true)
//    int findByRate(long id);
//   Optional<UserFilm> findUserFilmByFilmId(Long filmId);

}
