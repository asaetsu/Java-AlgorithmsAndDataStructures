import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinearSearchTest {

    public static class 初期状態の場合 {

        LinearSearch l;

        @Before
        public void setUp() {
            l = new LinearSearch();
        }

        @Test
        public void testAdd() {
            l.add(1, "one");
            String actual = (String) l.search(1);
            assertThat(actual, is("one"));
        }

        @Test
        public void testSearch() {
            String actual = (String) l.search(1);
            assertThat(actual, is(nullValue()));
        }
    }

    public static class データが追加されている場合 {

        LinearSearch l;

        @Before
        public void setUp() {
            l = new LinearSearch();
            l.add(1, "one");
        }

        @Test
        public void testSearch() {
            String actual = (String) l.search(1);
            assertThat(actual, is("one"));
        }

        @Test
        public void testAdd() {
            l.add(2, "two");
            String actual = (String) l.search(2);
            assertThat(actual, is("two"));
        }

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void testAddForIllegalStateException() throws Exception {
            thrown.expect(IllegalStateException.class);
            thrown.expectMessage("データの個数が多すぎます。");
            for (int i = 1; i < 101; i++) {
                l.add(i, String.valueOf(i));
            }
        }
    }
}
