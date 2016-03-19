import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyLinkedListIteratorTest {

    public static class 初期状態の場合 {

        MyLinkedList list;
        MyLinkedListIterator iterator;

        @Before
        public void setUp() {
            list = new MyLinkedList();
            iterator = new MyLinkedListIterator(list);
        }

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void testNext() {
            thrown.expect(NoSuchElementException.class);
            iterator.next();
        }

        @Test
        public void testHasNext() {
            assertFalse(iterator.hasNext());
        }
    }

    public static class データが追加されている場合 {

        MyLinkedList list;
        MyLinkedListIterator iterator;

        @Before
        public void setUp() {
            list = new MyLinkedList();
            list.insert(5);
            list.insert(8);
            list.insert(1);
            iterator = new MyLinkedListIterator(list);
        }

        @Test
        public void testHasNext() {
            assertTrue(iterator.hasNext());
        }
    }
}
