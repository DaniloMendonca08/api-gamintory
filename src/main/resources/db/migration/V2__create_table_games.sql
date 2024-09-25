CREATE TABLE GAMINTORY_GAMES (
    game_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    genre VARCHAR(50) NOT NULL,
    stars INT CHECK (stars IS NULL OR (stars >= 1 AND stars <= 5)),
    release_year INT CHECK (release_year >= 1958 AND release_year <= YEAR(CURRENT_TIMESTAMP)),
    time_played_in_hours INT,
    game_cover VARCHAR(255),
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_USER_ID_GAMES FOREIGN KEY (user_id) REFERENCES GAMINTORY_USERS(id)
);
