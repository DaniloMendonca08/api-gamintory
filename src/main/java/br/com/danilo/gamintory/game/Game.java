package br.com.danilo.gamintory.game;
import br.com.danilo.gamintory.game.validation.ValidReleaseYear;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "GAMINTORY_GAMES") // Use a convenção de nomenclatura correta
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id") // Mapeia para a coluna correta na tabela
    Long gameId;

    @Column(name = "user_id")
    Long userId;

    @NotBlank
    String name;

    String description;

    @NotBlank
    String genre;

    @Min(1)
    @Max(5)
    Integer stars;

    @NotNull
    @ValidReleaseYear
    @Column(name = "release_year")
    Integer releaseYear;

    Long time_played_in_hours;

    @NotBlank
    String game_cover;

    LocalDateTime added_at;



    @PrePersist
    protected void onCreate() {
        added_at = LocalDateTime.now();
    }

}

