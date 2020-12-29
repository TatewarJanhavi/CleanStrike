import enums.Messages;
import models.Player;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class TournamentTest {

    Tournament tournament;
    Player p1;
    Player p2;

    @Before
    public void setUp() {
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
        tournament = new Tournament(p1, p2);
    }

    @Test
    public void testPlayer2IsWinner() {
        String input = "1 1 1 3 7 1";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 2 || Player 2 : 5", tournament.printScore());
        assertEquals("Player 2", tournament.getGameStatus().getWinner(p1, p2).getName());

    }

    @Test
    public void testPlayer1IsWinner() {
        String input = "2 1 3";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 5 || Player 2 : 1", tournament.printScore());
        assertEquals("Player 1", tournament.getGameStatus().getWinner(p1, p2).getName());


    }

    @Test
    public void testGameIsDraw() {
        String input = "1 1 1 1 2 3 1 1 1 1 1";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 7 || Player 2 : 7", tournament.printScore());
        assertEquals("Sorry, Game is Draw", Messages.DRAW.getMessage());

    }

    @Test(expected = exceptions.CoinNotFoundException.class)
    public void testBlackCoinNotFound() {
        String input = "1 1 1 1 1 1 1 1 1 1";
        tournament.initialise(getInputStream(input));

    }

    @Test(expected = exceptions.CoinNotFoundException.class)
    public void testRedCoinNotFound() {
        String input = "3 3";
        tournament.initialise(getInputStream(input));

    }

    @Test
    public void testFoulOccursTwice() {
        String input = "1 5 1 5 1 1 1 7 1";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 5 || Player 2 : -3", tournament.printScore());
        assertEquals("Player 1", tournament.getGameStatus().getWinner(p1, p2).getName());
        assertEquals(2, p2.getNoOfFouls());

    }

    @Test
    public void testFoulOccursThrice() {
        String input = "1 5 1 5 2 5 1";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 5 || Player 2 : -8", tournament.printScore());
        assertEquals("Player 1", tournament.getGameStatus().getWinner(p1, p2).getName());
        assertEquals(0, p2.getNoOfFouls());

    }


    @Test
    public void testConsecutive2NoStrikeOccurs() {
        String input = "1 7 2 7 2";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 5 || Player 2 : 0", tournament.printScore());
        assertEquals("Player 1", tournament.getGameStatus().getWinner(p1, p2).getName());
        assertEquals(2, p2.getNoStrike());

    }

    @Test
    public void testConsecutive3NoStrikeOccurs() {
        String input = "1 7 2 4 1 5 3";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 7 || Player 2 : -4", tournament.printScore());
        assertEquals("Player 1", tournament.getGameStatus().getWinner(p1, p2).getName());
        assertEquals(0, p2.getNoStrike());

    }

    @Test
    public void testStrike() {
        String input = "1 8";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 1 || Player 2 : 0", tournament.printScore());
        assertEquals(1, p1.getPoints());
        assertEquals(0, p2.getPoints());
        assertEquals(8, tournament.getBlackCoins().getCoins());
    }

    @Test
    public void testMutiStrike() {
        String input = "2 8";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 2 || Player 2 : 0", tournament.printScore());
        assertEquals(2, p1.getPoints());
        assertEquals(0, p2.getPoints());

    }

    @Test
    public void testRedStrike() {
        String input = "3 8";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 3 || Player 2 : 0", tournament.printScore());
        assertEquals(3, p1.getPoints());
        assertEquals(0, p2.getPoints());
        assertEquals(0, tournament.getRedCoins().getCoins());
    }

    @Test
    public void testStrikerStrike() {
        String input = "4 8";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : -1 || Player 2 : 0", tournament.printScore());
        assertEquals(-1, p1.getPoints());
        assertEquals(0, p2.getPoints());
    }

    @Test
    public void testDefunctBlackCoinStrike() {
        String input = "5 8";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : -2 || Player 2 : 0", tournament.printScore());
        assertEquals(-2, p1.getPoints());
        assertEquals(0, p2.getPoints());
        assertEquals(8, tournament.getBlackCoins().getCoins());
    }

    @Test
    public void testDefunctRedCoinStrike() {
        String input = "6 8";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : -2 || Player 2 : 0", tournament.printScore());
        assertEquals(-2, p1.getPoints());
        assertEquals(0, p2.getPoints());
        assertEquals(0, tournament.getRedCoins().getCoins());
    }

    @Test
    public void testNone() {
        String input = "7 8";
        tournament.initialise(getInputStream(input));
        assertEquals("Current Score : Player 1 : 0 || Player 2 : 0", tournament.printScore());
        assertEquals(0, p1.getPoints());
        assertEquals(0, p2.getPoints());
        assertEquals(1, tournament.getRedCoins().getCoins());
        assertEquals(9, tournament.getBlackCoins().getCoins());
    }

    private InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
