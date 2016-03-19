/**
 * @author asaetsu 連結リスト 常に要素（整数）が昇順に並ぶようにする
 */
public class MyLinkedList implements Iterable {

    final Cell header; // リストの頭へのリンク

    public MyLinkedList() {
        header = new Cell("**Link Head**");
    }

    /**
     * 連結リストに要素numを挿入する。 要素は、連結リストが昇順になるような場所に挿入される
     * 
     * @param num
     */
    public void insert(int num) {
        Cell p = header.next;
        Cell q = header;
        while (p != null && num > (Integer) p.data) {
            q = p;// 1つ前
            p = p.next;
        }
        Cell newCell = new Cell(num);
        newCell.next = p;
        q.next = newCell;
    }

    /*
     * イテレータを得る
     * 
     * @return この連結リストに対するイテレータ
     */
    public MyLinkedListIterator iterator() {
        return new MyLinkedListIterator(this);
    }

    @Override
    public String toString() {
        String s = "[";
        for (Cell p = header.next; p != null; p = p.next) {
            s += p.data;
        }
        s += "]";
        return s;
    }
}
