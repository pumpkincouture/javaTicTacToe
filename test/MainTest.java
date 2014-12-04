import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by administrator on 12/4/14.
 */
public class MainTest {
    Main thing;

    @Before
    public void setUp() {
        thing = new Main("Andrew");
    }

    @Test
    public void test_true() throws Exception{
        assertEquals(true, true);
    }

    @Test
    public void test_hello() throws Exception{
        assertEquals("HelloAndrew" , thing.sayHello());
    }
}
