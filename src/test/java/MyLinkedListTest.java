import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {

    public static class 連結リストの先頭への操作 {

        MyLinkedList list;

        @Before
        public void setUp() {
            list = new MyLinkedList();
        }

        @Test
        public void testInsert() {
            list.insert(1);
            assertThat(list.toString(), is("[1]"));
        }
    }

    public static class データが追加されている場合 {

        MyLinkedList list;

        @Before
        public void setUp() {
            list = new MyLinkedList();
            list.insert(5);
        }

        @Test
        public void testInsert() {
            list.insert(2);
            list.insert(8);
            assertThat(list.toString(), is("[258]"));
        }
    }
}
