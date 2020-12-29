package models;

import enums.StrikeType;
import exceptions.CoinNotFoundException;
import interfaces.CoinsType;
import static enums.Coins.BLACK_COIN;
import static enums.Messages.BLACK_COINS_NOT_FOUND;

public class BlackCoins implements CoinsType {

    private int coins;

    public BlackCoins(){
        this.coins = BLACK_COIN.getNumberOfCoins();
    }

    public int getCoins(){
        return this.coins;
    }

   public void updateCoins(StrikeType strikeType)
     {
         if(this.coins >= strikeType.getBlackCoin()){
           this.coins -= strikeType.getBlackCoin();
        }
         else
            throw new CoinNotFoundException(BLACK_COINS_NOT_FOUND.getMessage());
     }

}
