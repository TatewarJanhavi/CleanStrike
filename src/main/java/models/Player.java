package models;


import enums.StrikeType;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
public class Player {

    public static final int CONSECUTIVE_NO_STRIKE_LIMIT = 3;
    public static final int FOUL_LIMIT = 3;
    @NonNull
    private String name;
    private int points;
    private int noOfFouls;
    private int noStrike;

    public Player(@NonNull String name) {
        this.name = name;
    }

    public void evaluatePoints(StrikeType strikeType) {
        setPoints(strikeType);
        if (strikeType.getPoints() > 0)
            resetStrike();
        else {
            getStrikeHistory();
            if (strikeType.getPoints() != 0)
                getFoul();
        }
    }

    private void getFoul() {
        this.noOfFouls++;
        if (noOfFouls == FOUL_LIMIT) {
            setPoints(StrikeType.FOUL);
            resetFoul();
        }

    }

    private void resetFoul() {
        this.noOfFouls = 0;
    }

    private void setPoints(StrikeType strikeType) {
        this.points += strikeType.getPoints();
    }

    private void getStrikeHistory() {
        this.noStrike++;
        if (this.noStrike == CONSECUTIVE_NO_STRIKE_LIMIT) {
            setPoints(StrikeType.CONSECUTIVE_3_NO_STRIKE);
            resetStrike();
        }
    }

    private void resetStrike() {
        this.noStrike = 0;
    }


}
