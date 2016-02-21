import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author asaetsu 配列によるスタックの実装（ジェネリック版）
 */
public class GenericStack<E> {
    private E stack[];// stackの本体
    private int stackSize;// stackの大きさ
    private int sp;// stackのポインタ

    private static final int DEFAULT_STACK_SIZE = 100;// デフォルトのstackの大きさ

    /**
     * スタックを生成する
     */
    public GenericStack() {
        this(DEFAULT_STACK_SIZE);
    }

    /**
     * 大きさを指定してスタックを生成する
     * 
     * @param size
     *            //スタックの大きさ
     */
    @SuppressWarnings("unchecked")
    public GenericStack(int size) {
        stack = (E[]) new Object[size];
        stackSize = size;
        sp = 0;
    }

    /**
     * スタックの中身を捨てて空の状態にする
     */
    public void clear() {
        Arrays.fill(stack, 0, sp, null);// スタックをnullでクリアする
        sp = 0;// スタックポインタを0にする
    }

    /**
     * スタックにデータを積む
     * 
     * @param x
     *            //積むデータ
     */
    public void push(E x) {
        if (sp >= stackSize) {
            throw new IllegalStateException("Stack overflow");
        }
        stack[sp++] = x;
    }

    /**
     * スタックからデータを降ろす
     * 
     * @return　スタックから降ろしたデータ
     */
    public E pop() {
        if (sp <= 0) {
            throw new EmptyStackException();
        }
        E value = stack[--sp];
        stack[sp] = null;// 空いた要素をnullでクリアする
        return value;
    }

    /**
     * スタックが空かどうかを調べる
     * 
     * @return　空ならばtrue、空でなければfalseを返す
     */
    public boolean isEmpty() {
        return sp == 0;
    }

    /*
     * スタックの内容を表す文字列を返す
     * 
     * @return スタックの内容を表す文字列
     */
    @Override
    public String toString() {
        String s = "GenericStack=[";
        for (int i = 0; i < sp; i++) {
            s = s + stack[i];
            if (i < sp - 1)
                s = s + ",";
        }
        s = s + "]";
        return s;
    }
}
