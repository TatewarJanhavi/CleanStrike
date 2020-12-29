package enums;

import lombok.Getter;

public enum StrikeType {
    STRIKE(1, 1, 0),
    MULTI_STRIKE(2),
    RED_STRIKE(3, 0, 1),
    STRIKER_STRIKE(-1),
    DEFUNCT_BLACK_COIN(-2, 1, 0),
    DEFUNCT_RED_COIN(-2, 0, 1),
    NONE(0),
    FOUL(-1),
    CONSECUTIVE_3_NO_STRIKE(-1);

    @Getter
    private int points;
    @Getter
    private int blackCoin;

    @Getter
    private int redCoin;

    StrikeType(int points) {
        this.points = points;
        this.blackCoin = 0;
        this.redCoin = 0;
    }

    StrikeType(int points, int blackCoin, int redCoin) {
        this.points = points;
        this.blackCoin = blackCoin;
        this.redCoin = redCoin;
    }
}
