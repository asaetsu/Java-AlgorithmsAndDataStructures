import java.util.EmptyStackException;

/**
 * @author asaetsu 双方向リストによるスタックの実装
 *
 */
public class MyDoubleLinkedListStack {
    private MyDoubleLinkedList stack; // スタックの実体を表す双方向リスト
    private int nElements; // スタックに入っている要素の個数

    /**
     * スタックを生成する
     */
    public MyDoubleLinkedListStack() {
        // スタックの実体の双方向リストを割り当てる
        stack = new MyDoubleLinkedList();
        // 要素の個数を0にする
        nElements = 0;
    }

    public void clear() {
        // スタックの実体の双方向リストを作り直す
        stack = new MyDoubleLinkedList();
        // 要素の個数を0にする
        nElements = 0;
    }

    /**
     * スタックにデータを積む
     * 
     * @param x
     *            　積むデータ
     */
    public void push(Object x) {
        stack.insertLast(x);
        nElements++;
    }

    /**
     * スタックからデータを降ろす
     * 
     * @return　スタックから降ろしたデータ
     */
    public Object pop() {
        if (nElements-- <= 0) {
            throw new EmptyStackException();
        }
        return stack.removeLast();
    }

    /**
     * スタックが空かどうかを調べる
     * 
     * @return　空ならばtrue、空でなければfalse
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
