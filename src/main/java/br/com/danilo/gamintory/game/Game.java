package br.com.danilo.gamintory.game;

import br.com.danilo.gamintory.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "gamintory_games")
@Data
public class Game {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String name;

    String description;

    @NotBlank
    String genre;

    @Min(1)
    @Max(5)
    Integer stars;

    @NotBlank
    Integer releaseYear;


    Long timePlayedInHours;

    @NotBlank
    String gameCover;


    LocalDateTime addedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    protected void onCreate() {
        addedAt = LocalDateTime.now();
    }

}
