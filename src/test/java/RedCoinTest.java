import enums.StrikeType;
import models.RedCoins;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RedCoinTest {
    RedCoins redCoins;

    @Before
    public void setUp() {
        redCoins = new RedCoins();
    }

    @Test
    public void testUpdateCoinStrike() {
        redCoins.updateCoins(StrikeType.STRIKE);
        assertEquals(1, redCoins.getCoins());
    }

    @Test
    public void testUpdateCoinMultiStrike() {
        redCoins.updateCoins(StrikeType.MULTI_STRIKE);
        assertEquals(1, redCoins.getCoins());
    }

    @Test
    public void testUpdateCoinRedStrike() {
        redCoins.updateCoins(StrikeType.RED_STRIKE);
        assertEquals(0, redCoins.getCoins());
    }

    @Test
    public void testUpdateCoinStrikerStrike() {
        redCoins.updateCoins(StrikeType.STRIKER_STRIKE);
        assertEquals(1, redCoins.getCoins());
    }

    @Test
    public void testUpdateCoinDefunctBlackCoin() {
        redCoins.updateCoins(StrikeType.DEFUNCT_BLACK_COIN);
        assertEquals(1, redCoins.getCoins());
    }

    @Test
    public void testUpdateCoinDefunctRedCoin() {
        redCoins.updateCoins(StrikeType.RED_STRIKE);
        assertEquals(0, redCoins.getCoins());
    }

    @Test(expected = exceptions.CoinNotFoundException.class)
    public void testRedCoinNotFound() {
        redCoins.updateCoins(StrikeType.RED_STRIKE);
        redCoins.updateCoins(StrikeType.RED_STRIKE);


    }
}
