import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Created by administrator on 12/4/14.
 */
public class PlayerTest {
    Player test;

    @Before
    public void setUp() {
        test = new Player("X");
    }

    @Test
    public void printPiece() {
        assertEquals("X", test.getGamePiece());
    }
}
