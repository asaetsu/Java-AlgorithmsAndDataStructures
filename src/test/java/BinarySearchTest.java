import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    public static class 初期状態の場合 {

        BinarySearch b;

        @Before
        public void setUp() {
            b = new BinarySearch();
        }

        @Test
        public void testSearch() {
            String actual = (String) b.search(1);
            assertThat(actual, is(nullValue()));
        }
    }

    public static class データが追加されている場合 {
        // TODO add完了後
    }
}
