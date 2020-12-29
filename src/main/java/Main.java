import models.Player;

public class Main {
    public static void main(String args[]) {

        new Tournament(new Player("PLAYER  1"), new Player("PLAYER 2")).initialise(System.in);
    }
}
