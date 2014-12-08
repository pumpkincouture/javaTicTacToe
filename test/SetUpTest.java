import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by administrator on 12/8/14.
 */
public class SetUpTest {
    SetUp test;
    Player player1;
    Player player2;
    Board boardTest;

    @Before
    public void createTest() {
        player1 = new Player("X");
        player2 = new Player("O");
        boardTest = new Board();
        test = new SetUp();
    }

    @Test
    public void createFirstPlayer() {
        System.out.println(test.createPlayer());
    }
}
