import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyQueueTest {

    public static class 初期状態の場合 {

        MyQueue m;

        @Before
        public void setUp() {
            m = new MyQueue();
        }

        @Test
        public void testIsEmpty() {
            assertTrue(m.isEmpty());
        }

        @Test
        public void testEnqueu() {
            String expected = "a";
            m.enqueu(expected);
            assertThat((String) m.dequeu(), is(expected));
        }

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void testDequeuForNoSuchElementException() throws Exception {
            thrown.expect(NoSuchElementException.class);
            thrown.expectMessage("待ち行列が空なので要素を取り出せません。");
            m.dequeu();
        }
    }

    public static class データが追加されている場合 {

        MyQueue m;

        @Before
        public void setUp() {
            m = new MyQueue();
            m.enqueu("a");
        }

        @Test
        public void testIsEmpty() {
            assertFalse(m.isEmpty());
        }

        @Test
        public void testEnqueu() {
            m.enqueu("b");
            assertThat((String) m.dequeu(), is("a"));
            assertThat((String) m.dequeu(), is("b"));
        }

        @Test
        public void testDequeu() {
            assertThat((String) m.dequeu(), is("a"));
        }

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void testEnqueuForIllegalArgumentException() throws Exception {
            thrown.expect(IllegalArgumentException.class);
            thrown.expectMessage("これ以上、待ち行列に要素を追加できません。");
            for (int i = 0; i < 100; i++) {
                m.enqueu(String.valueOf(i));
            }
        }

        @Test
        public void testClear() {
            assertFalse(m.isEmpty());
            m.clear();
            assertTrue(m.isEmpty());
        }
    }
}
