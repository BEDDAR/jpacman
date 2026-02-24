package nl.tudelft.jpacman.level;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.EnumMap;
import java.util.Map;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.sprite.AnimatedSprite;
import nl.tudelft.jpacman.sprite.Sprite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;

    // On construit un vrai Player pour tester son comportement interne.
    @BeforeEach
    void setUp() {
        Map<Direction, Sprite> sprites = new EnumMap<>(Direction.class);
        for (Direction dir : Direction.values()) {
            sprites.put(dir, mock(Sprite.class));
        }
        player = new Player(sprites, mock(AnimatedSprite.class));
    }

    // Un joueur créé doit avoir exactement 3 vies.
    private static final int INITIAL_LIVES = 3;

    @Test
    void startsWithThreeLives() {
        assertThat(player.getLives()).isEqualTo(INITIAL_LIVES);
    }

    // Chaque appel à loseLife() doit décrémenter d'exactement 1.
    @Test
    void loseLifeDecrementsLives() {
        player.loseLife();
        assertThat(player.getLives()).isEqualTo(2);
    }

}
