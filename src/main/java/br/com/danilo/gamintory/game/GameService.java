package br.com.danilo.gamintory.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository repository;

    public Game add(Game game) {
        return repository.save(game);
    }

    public List<Game> findAll() {
        return repository.findAll();
    }

    public List<Game> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Game> findByGenre(String genre) {
        return repository.findByGenreContainingIgnoreCase(genre);
    }

    public List<Game> findByStars(Integer stars) {
        return repository.findByStars(stars);
    }

    public List<Game> findByYear(Integer year) {
        return repository.findByReleaseYear(year);
    }
}
