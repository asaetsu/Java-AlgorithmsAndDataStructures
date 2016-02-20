import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {

    Position p;

    @Before
    public void setUp() {
        p = new Position(10, 20);
    }

    @Test
    public void testGetX() {
        int actual = p.getX();
        assertThat(actual, is(10));
    }

    @Test
    public void testGetY() {
        int actual = p.getY();
        assertThat(actual, is(20));
    }

    @Test
    public void testMoveX() {
        p.moveX(1);
        int actual = p.getX();
        assertThat(actual, is(11));
    }

    @Test
    public void testMoveY() {
        p.moveY(1);
        int actual = p.getY();
        assertThat(actual, is(21));
    }

    @Test
    public void testHashCode() {
        // todo
    }
}
