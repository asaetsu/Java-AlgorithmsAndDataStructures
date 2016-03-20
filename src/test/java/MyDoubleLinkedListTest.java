import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyDoubleLinkedListTest {

    public static class 初期状態の場合 {

        MyDoubleLinkedList list;

        @Before
        public void setUp() {
            list = new MyDoubleLinkedList();
        }

        @Test
        public void testInsertFirst() {
            list.insertFirst("a");
            assertThat(list.toString(), is("[a]"));
        }

        @Test
        public void testInsertLast() {
            list.insertLast("a");
            list.insertLast("b");
            assertThat(list.toString(), is("[ab]"));
        }

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void testremoveFirst() {
            thrown.expect(NoSuchElementException.class);
            list.removeFirst();
        }

        @Test
        public void testremoveLast() {
            thrown.expect(NoSuchElementException.class);
            list.removeLast();
        }

        @Test
        public void testIsEmpty() {
            assertTrue(list.isEmpty());
        }
    }

    public static class データが追加されている場合 {

        MyDoubleLinkedList list;

        @Before
        public void setUp() {
            list = new MyDoubleLinkedList();
            list.insertFirst("a");
        }

        @Test
        public void testInsertFirst() {
            list.insertFirst("b");
            assertThat(list.toString(), is("[ba]"));
        }

        @Test
        public void testInsertLast() {
            list.insertLast("b");
            assertThat(list.toString(), is("[ab]"));
        }

        @Test
        public void testremoveFirst() {
            list.insertLast("b");
            String removedData = (String) list.removeFirst();
            assertThat(removedData, is("a"));
            assertThat(list.toString(), is("[b]"));
        }

        @Test
        public void testremoveLast() {
            list.insertLast("b");
            String removedData = (String) list.removeLast();
            assertThat(removedData, is("b"));
            assertThat(list.toString(), is("[a]"));
        }

        @Test
        public void testIsEmpty() {
            assertFalse(list.isEmpty());
        }
    }
}
