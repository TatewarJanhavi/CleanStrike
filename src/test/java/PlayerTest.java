import enums.StrikeType;
import models.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player p1;

    @Before
    public void setUp() {
        p1 = new Player("Player 1");
    }

    @Test
    public void testStrikeForEvalutePoint() {
        p1.evaluatePoints(StrikeType.STRIKE);
        assertEquals(1, p1.getPoints());
    }

    @Test
    public void testMultiStrikeForEvalutePoint() {
        p1.evaluatePoints(StrikeType.MULTI_STRIKE);
        assertEquals(2, p1.getPoints());
    }

    @Test
    public void testRedStrikeForEvalutePoint() {
        p1.evaluatePoints(StrikeType.RED_STRIKE);
        assertEquals(3, p1.getPoints());
    }

    @Test
    public void testStrikerStrikeForEvalutePoint() {
        p1.evaluatePoints(StrikeType.STRIKER_STRIKE);
        assertEquals(-1, p1.getPoints());
    }

    @Test
    public void testDefuntStrikerForEvalutePoint() {
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        assertEquals(-2, p1.getPoints());
    }

    @Test
    public void testNoneForEvalutePoint() {
        p1.evaluatePoints(StrikeType.NONE);
        assertEquals(0, p1.getPoints());
    }

    @Test
    public void testFoulOccursOnce() {
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        assertEquals(-2, p1.getPoints());
        assertEquals(1, p1.getNoOfFouls());
    }

    @Test
    public void testFoulOccursThrice() {
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        p1.evaluatePoints(StrikeType.STRIKE);
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        assertEquals(-6, p1.getPoints());
        assertEquals(0, p1.getNoOfFouls());
    }

    @Test
    public void testNoStrikeOccursOnce() {
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        assertEquals(-2, p1.getPoints());
        assertEquals(1, p1.getNoStrike());
    }

    @Test
    public void testConsecustive3NostrikeOccurs() {
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        p1.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);
        assertEquals(-8, p1.getPoints());
        assertEquals(0, p1.getNoStrike());
    }
}
