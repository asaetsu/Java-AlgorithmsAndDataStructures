/**
 * @author asaetsu ハッシュ表で扱うキー
 *
 */
public class MyKey {
    String str; // キーとなる文字列

    /**
     * キーを作成する
     * 
     * @param s
     *            　キーとなる文字列
     */
    public MyKey(String s) {
        this.str = s;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyKey)) {
            return false;
        }
        MyKey k = (MyKey) o;
        return str.equals(k.str);
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        return str;
    }
}
