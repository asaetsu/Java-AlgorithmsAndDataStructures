import java.util.NoSuchElementException;

/**
 * @author asaetsu 双方向リスト
 *
 */
public class MyDoubleLinkedList {
    final CellDouble head; // リストの頭へのリンク

    /**
     * 双方向リストを生成する。 生成される双方向リストは空になっている
     */
    public MyDoubleLinkedList() {
        // リストの頭を割り当てる
        head = new CellDouble("**List Head**");
        // リストの頭のprevとnextが自分自身を指すようにする
        head.prev = head.next = head;
    }

    /**
     * 双方向リストのセルpの直後にデータdataを挿入する
     * 
     * @param p
     *            このセルの直後にデータを挿入する
     * @param data
     *            挿入するデータ
     */
    private void insertAfter(CellDouble p, Object data) {
        CellDouble x = new CellDouble(data);
        x.prev = p;
        x.next = p.next;
        p.next.prev = x;
        p.next = x;
    }

    /**
     * 双方向リストの先頭にデータdataを挿入する
     * 
     * @param data
     *            　挿入するデータ
     */
    public void insertFirst(Object data) {
        insertAfter(head, data);
    }

    /**
     * 双方向リストの末尾にデータdataを挿入する
     * 
     * @param data
     *            　挿入するデータ
     */
    public void insertLast(Object data) {
        // 最後の要素の次に挿入する
        insertAfter(head.prev, data);
    }

    /**
     * 指定されたセルを削除する
     * 
     * @param p
     */
    private void removeCell(CellDouble p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
    }

    /**
     * 双方向リストの先頭のデータを削除する
     * 
     * @return　削除した要素を返す ただし要素がなければ例外NoSuchElementExceptionをスローする
     */
    public Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("双方向リストが空です。");
        }
        CellDouble cell = head.next;
        removeCell(cell);
        return cell.data;
    }

    /**
     * 双方向リストの末尾のデータを削除する
     * 
     * @return　削除した要素を返す。ただし、要素がなければ例外NoSuchElementExceptionをスローする
     */
    public Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        CellDouble cell = head.prev;
        removeCell(cell);
        return cell.data;
    }

    /**
     * 双方向リストが空かどうかをチェックする
     * 
     * @return 空ならばtrue、空でなければfalse
     */
    public boolean isEmpty() {
        return head.next == head;
    }

    @Override
    public String toString() {
        String s = "[";
        for (CellDouble p = head.next; p != head; p = p.next) {
            s += p.data;
        }
        s += "]";
        return s;
    }
}
