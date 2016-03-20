import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyDoubleLinkedListStackTest {

    public static class 初期状態の場合 {

        MyDoubleLinkedListStack stack;

        @Before
        public void setUp() {
            stack = new MyDoubleLinkedListStack();
        }

        @Test
        public void testPush() {
            stack.push("a");
            assertThat(stack.toString(), is("[a]"));
        }

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void testPop() {
            thrown.expect(EmptyStackException.class);
            stack.pop();
        }

        @Test
        public void testIsEmpty() {
            assertTrue(stack.isEmpty());
        }
    }

    public static class データが追加されている場合 {

        MyDoubleLinkedListStack stack;

        @Before
        public void setUp() {
            stack = new MyDoubleLinkedListStack();
            stack.push("a");
        }

        @Test
        public void testPush() {
            stack.push("b");
            assertThat(stack.toString(), is("[ab]"));
        }

        @Test
        public void testPop() {
            stack.push("b");
            String value = (String) stack.pop();
            assertThat(value, is("b"));
            assertThat(stack.toString(), is("[a]"));
        }

        @Test
        public void testIsEmpty() {
            assertFalse(stack.isEmpty());
        }
    }
}
