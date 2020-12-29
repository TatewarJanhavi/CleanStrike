package models;


import enums.StrikeType;
import exceptions.CoinNotFoundException;
import interfaces.CoinsType;
import static enums.Coins.RED_COIN;
import static enums.Messages.RED_COINS_NOT_FOUND;

public class RedCoins implements CoinsType {
    private int coins;

    public RedCoins() {
        this.coins = RED_COIN.getNumberOfCoins();
    }

    public int getCoins() {
        return this.coins;
    }

    public void updateCoins(StrikeType strikeType) {
        if (this.coins >= strikeType.getRedCoin())
            this.coins -= strikeType.getRedCoin();
        else
            throw new CoinNotFoundException(RED_COINS_NOT_FOUND.getMessage());
    }
}
