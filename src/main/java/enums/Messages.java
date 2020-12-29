package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Messages {

    WIN(" won the game !! \n"),
    DRAW("Sorry, Game is Draw"),
    RED_COINS_NOT_FOUND("Red Coins Not Found"),
    BLACK_COINS_NOT_FOUND("Black Coins Not Found"),
    PLAYER("Player "),
    CURRENT_SCORE("Current Score : "),
    SEPARATOR(" || "),
    OPTIONS("Choose an outcome from the list below\n" +
            "1. Strike\n" +
            "2. Multistrike\n" +
            "3. Red strike\n" +
            "4. Striker strike\n" +
            "5. Defunct Black coin\n" +
            "6. Defunct Red coin\n" +
            "7. None \n" +
            "8. Exit");

    @Getter
    private String message;

}
