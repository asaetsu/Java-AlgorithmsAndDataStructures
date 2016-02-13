import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinearSearchTest {
    LinearSearch l;

    @Before
    public void setUp() {
        l = new LinearSearch();
    }

    @After
    public void tearDown() {
        l = null;
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAdd() {
        for (int i = 1; i < 101; i++) {
            l.add(i, String.valueOf(i));
        }
    }

    @Test
    public void testAddForIllegalStateException() throws Exception {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("データの個数が多すぎます。");
        for (int i = 1; i < 102; i++) {
            l.add(i, String.valueOf(i));
        }
    }

    @Test
    public void testSearch() {
        for (int i = 1; i < 101; i++) {
            l.add(i, String.valueOf(i));
        }
        String actual = (String) l.search(5);
        assertThat("5", is(actual));
    }
}
