package br.com.danilo.gamintory.user;

import br.com.danilo.gamintory.game.Game;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "gamintory_users")
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String username;
    String password;
    LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Game> games;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
