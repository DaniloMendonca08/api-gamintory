package br.com.danilo.gamintory.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameService service;

    public ResponseEntity<Game> add(Game game, UriComponentsBuilder uriBuilder) {
        service.add(game);

        var uri = uriBuilder
                .path("/games/{id}")
                .buildAndExpand(game.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(game);
    }

    @GetMapping
    public List<Game> findAll() {
        return service.findAll();
    }

    @GetMapping
    public List<Game> findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @GetMapping
    public List<Game> findByGenre(@RequestParam String genre) {
        return service.findByGenre(genre);
    }

    @GetMapping
    public List<Game> findByStars(@RequestParam Integer stars) {
        return service.findByStars(stars);
    }

    @GetMapping
    public List<Game> findByYear(@RequestParam Integer year) {
        return service.findByYear(year);
    }
}
