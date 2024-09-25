package br.com.danilo.gamintory.game;

import br.com.danilo.gamintory.auth.TokenService;
import br.com.danilo.gamintory.user.UserService;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameService service;

    private final UserService userService;

    public GameController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game game, UriComponentsBuilder uriBuilder) {

        service.add(game);

        var uri = uriBuilder
                .path("/games/{id}")
                .buildAndExpand(game.getGameId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(game);
    }

    @GetMapping
    public Page<Game> findAll(@PageableDefault(size = 3)Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/name")
    public List<Game> findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @GetMapping("/genre")
    public List<Game> findByGenre(@RequestParam String genre) {
        return service.findByGenre(genre);
    }

    @GetMapping("/stars")
    public List<Game> findByStars(@RequestParam Integer stars) {
        return service.findByStars(stars);
    }

    @GetMapping("/year")
    public List<Game> findByYear(@RequestParam Integer year) {
        return service.findByYear(year);
    }
}
