import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 連結リストのイテレータ
 * 
 * @author asaetsu
 *
 */
public class MyLinkedListIterator implements Iterator {
    private Cell p; // 現在着目しているセルを示すカーソル

    /**
     * イテレータを設定する
     * 
     * @param list
     *            　イテレータの対象となるMyLinkedListオブジェクト
     */
    public MyLinkedListIterator(MyLinkedList list) {
        // 着目点をリストの頭に設定する
        p = list.header;
    }

    /*
     * 次の要素があるならtrueを返す
     * 
     * @return 次の要素があればtrue、なければfalseを返す
     */
    public boolean hasNext() {
        return p.next != null;
    }

    /*
     * 次の要素を返す
     * 
     * @return 次の要素がもつ値
     */
    public Object next() {
        // 次の要素が存在しなければ例外NoSuchElementExceptionをスローする
        if (p.next == null) {
            throw new NoSuchElementException();
        }
        p = p.next;
        return p.data;
    }

    public void remove() {
        // このメソッドは未定義である
        // 例外UnsupportedOperationExceptionを投げる
        throw new UnsupportedOperationException();
    }
}
