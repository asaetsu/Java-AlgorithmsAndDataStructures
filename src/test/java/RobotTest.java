import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {

    Robot r;
    String name = "ロビタ";
    String cloneName = "ロビタclone";

    @Before
    public void setUp() {
        r = new Robot(new Position(10, 20), "ロビタ");
    }

    @Test
    public void testGetPosition() {
        int actualX = r.getPosition().getX();
        int actualY = r.getPosition().getY();
        assertThat(actualX, is(10));
        assertThat(actualY, is(20));
    }

    @Test
    public void testMoveX() {
        r.moveX(1);
        int actual = r.getPosition().getX();
        assertThat(actual, is(11));
    }

    @Test
    public void testMoveY() {
        r.moveY(1);
        int actual = r.getPosition().getY();
        assertThat(actual, is(21));
    }

    @Test
    public void testMoveXY() {
        r.moveXY(1, 1);
        int actualX = r.getPosition().getX();
        int actualY = r.getPosition().getY();
        assertThat(actualX, is(11));
        assertThat(actualY, is(21));
    }

    @Test
    public void testGetName() {
        r.getName();
        String actual = r.getName();
        assertThat(actual, is(name));
    }

    @Test
    public void testMakeClone() {
        Robot r2 = r.makeClone();

        r.moveXY(1, 2);
        assertThat(r.getPosition().getX(), is(11));
        assertThat(r.getPosition().getY(), is(22));

        assertThat(r2.getName(), is(cloneName));
        assertThat(r2.getPosition().getX(), is(10));
        assertThat(r2.getPosition().getY(), is(20));
    }
}
