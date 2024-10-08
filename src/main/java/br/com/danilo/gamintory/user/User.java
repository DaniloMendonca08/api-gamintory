package br.com.danilo.gamintory.user;

import br.com.danilo.gamintory.game.Game;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "gamintory_users")
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String name;

    @NotBlank
    String username;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    String password;


    LocalDateTime createdAt;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Game> games;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
