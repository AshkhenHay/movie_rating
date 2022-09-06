package com.epam.movie_rating.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "user_film")
public class UserFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "rate")
    private int rate;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "film_id")
    private Long filmId;
}


