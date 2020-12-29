import enums.StrikeType;
import models.BlackCoins;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackCoinTest {
    BlackCoins blackCoins;

    @Before
    public void setUp() {
        blackCoins = new BlackCoins();
    }

    @Test
    public void testUpdateCoinStrike() {
        blackCoins.updateCoins(StrikeType.STRIKE);
        assertEquals(8, blackCoins.getCoins());
    }

    @Test
    public void testUpdateCoinMultiStrike() {
        blackCoins.updateCoins(StrikeType.MULTI_STRIKE);
        assertEquals(9, blackCoins.getCoins());
    }

    @Test
    public void testUpdateCoinRedStrike() {
        blackCoins.updateCoins(StrikeType.RED_STRIKE);
        assertEquals(9, blackCoins.getCoins());
    }

    @Test
    public void testUpdateCoinStrikerStrike() {
        blackCoins.updateCoins(StrikeType.STRIKER_STRIKE);
        assertEquals(9, blackCoins.getCoins());
    }

    @Test
    public void testUpdateCoinDefunctBlackCoin() {
        blackCoins.updateCoins(StrikeType.DEFUNCT_BLACK_COIN);
        assertEquals(8, blackCoins.getCoins());
    }

    @Test
    public void testUpdateCoinDefunctRedCoin() {
        blackCoins.updateCoins(StrikeType.RED_STRIKE);
        assertEquals(9, blackCoins.getCoins());
    }

    @Test(expected = exceptions.CoinNotFoundException.class)
    public void testBlackCoinNotFound() {
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);
        blackCoins.updateCoins(StrikeType.STRIKE);

    }
}
