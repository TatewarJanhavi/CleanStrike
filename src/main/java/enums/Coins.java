package enums;

import lombok.Getter;

public enum Coins {

    BLACK_COIN(9),
    RED_COIN(1);

    @Getter
    int numberOfCoins;

    Coins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }
}
