package br.com.danilo.gamintory.game;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByNameContainingIgnoreCase(String name);

    List<Game> findByGenreContainingIgnoreCase(String genre);

    List<Game> findByStars(Integer stars);

    List<Game> findByReleaseYear(Integer releaseYear);

}
