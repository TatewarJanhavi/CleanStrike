import enums.StrikeType;
import interfaces.CoinsType;
import lombok.Getter;
import models.*;

import java.io.InputStream;
import java.util.Scanner;

import static enums.Messages.*;

@Getter
public class Tournament {

    private Player player1;
    private Player player2;
    private Player striker;
    private Player winner;
    private CoinsType blackCoins;
    private CoinsType redCoins;
    private GameStatus gameStatus;

    public Tournament(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.blackCoins = new BlackCoins();
        this.redCoins = new RedCoins();
        this.gameStatus = new GameStatus();
        striker = player1;
    }

    public String printScore() {
        return (CURRENT_SCORE.getMessage() + this.player1.getName() + " : " + this.player1.getPoints()
                + SEPARATOR.getMessage() + this.player2.getName() + " : " + this.player2.getPoints());
    }

    public void initialise(InputStream in) {
        Scanner scanner = new Scanner(in);
        do {
            int option = printStrikeTypes(scanner);
            if (option == 8) return;
            start(option);
            winner = gameStatus.getWinner(player1, player2);
            if (winner != null) {
                System.out.println(winner.getName() + WIN.getMessage() + printScore());
                return;
            }
            System.out.println(printScore());
        } while (blackCoins.getCoins() != 0 || redCoins.getCoins() != 0);

        System.out.println(DRAW.getMessage());
    }

    public void changePlayer() {

        if (striker.getName().equals(player1.getName())) {
            striker = player2;
        } else {
            striker = player1;
        }
    }

    private void start(int option) {
        switch (option) {
            case 1:
                striker.evaluatePoints(StrikeType.STRIKE);
                blackCoins.updateCoins(StrikeType.STRIKE);
                changePlayer();
                break;
            case 2:
                striker.evaluatePoints(StrikeType.MULTI_STRIKE);
                changePlayer();
                break;
            case 3:
                striker.evaluatePoints(StrikeType.RED_STRIKE);
                redCoins.updateCoins(StrikeType.RED_STRIKE);
                changePlayer();
                break;
            case 4:
                striker.evaluatePoints(StrikeType.STRIKER_STRIKE);
                changePlayer();
                break;
            case 5:
                striker.evaluatePoints(StrikeType.DEFUNCT_BLACK_COIN);

                blackCoins.updateCoins(StrikeType.DEFUNCT_BLACK_COIN);
                changePlayer();
                break;
            case 6:
                striker.evaluatePoints(StrikeType.DEFUNCT_RED_COIN);

                redCoins.updateCoins(StrikeType.DEFUNCT_RED_COIN);
                changePlayer();
                break;
            case 7:
                striker.evaluatePoints(StrikeType.NONE);
                changePlayer();
                break;
            case 8:
                return;
        }

    }

    private int printStrikeTypes(Scanner in) {
        System.out.println(PLAYER.getMessage() + striker.getName());
        System.out.println(OPTIONS.getMessage());
        return in.nextInt();
    }


}
