import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GenericStackTest {

    public static class 初期状態の場合 {

        GenericStack<Integer> g;

        @Before
        public void setUp() {
            g = new GenericStack<Integer>();
        }

        @Test
        public void testPush() {
            g.push(1);
            assertThat(g.pop(), is(1));
        }

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void testPop() {
            thrown.expect(EmptyStackException.class);
            g.pop();
        }

        @Test
        public void testIsEmpty() {
            boolean isEmpty = g.isEmpty();
            assertTrue(isEmpty);
        }

        @Test
        public void testToString() {
            String actual = g.toString();
            assertThat(actual, is("GenericStack=[]"));
        }
    }

    public static class データが追加されている場合 {

        GenericStack<Integer> g;

        @Before
        public void setUp() {
            g = new GenericStack<Integer>();
            g.push(1);
        }

        @Test
        public void testPush() {
            g.push(2);
            assertThat(g.pop(), is(2));
        }

        @Test
        public void testPop() {
            Integer value = g.pop();
            assertThat(value, is(1));
        }

        @Test
        public void testIsEmpty() {
            boolean isEmpty = g.isEmpty();
            assertFalse(isEmpty);
        }

        @Test
        public void testToString() {
            String actual = g.toString();
            assertThat(actual, is("GenericStack=[1]"));
        }
    }
}
