
/**
 * Created by administrator on 12/9/14.
 */
public class Game {

    private SetUp setup;

    public Game() {
        this.setup = new SetUp();
    }

    public void printPlayers() {
        System.out.println(setup.getBoard());
        System.out.println(setup.getFirstPlayer());
        System.out.println(setup.getSecondPlayer());
    }
}
