package models;

public class GameStatus {

    public static final int MIN_WINNING_POINTS = 5;
    public static final int WIN_POINT_DIFF = 3;

    public Player getWinner(Player player1, Player player2) {

        if (((player1.getPoints() >= MIN_WINNING_POINTS) || (player2.getPoints() >= MIN_WINNING_POINTS))
                && (Math.abs(player1.getPoints() - player2.getPoints()) >= WIN_POINT_DIFF)) {
            return player1.getPoints() > player2.getPoints() ? player1 : player2;
        }
        return null;
    }


}
