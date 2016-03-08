import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

/**
 * @author asaetsu 逆ポーランド電卓
 */
public class Calculator {
    private final GenericStack<Long> stack;// スタック

    /**
     * 逆ポーランド電卓オブジェクトを生成する
     */
    public Calculator() {
        stack = new GenericStack<Long>();
    }

    public long compute(String exp) throws IOException {
        // スタックの内容をクリアする
        stack.clear();

        // 文字列expを一文字ずつ読み込むためのリーダーを用意する
        // PushbackReader クラスを利用して、読みすぎた文字をunreadを戻せるようにしている。
        // 文字列の末尾に、式の終わりを示す
        PushbackReader input = new PushbackReader(new StringReader(exp + ";"));

        // セミコロンに出会うまで、1文字読み込んで繰り返す
        int c;// 読み込んだ文字
        while ((c = input.read()) != ';') {
            char ch = (char) c;
            // 指定された文字が数字かどうかを判定します。
            if (Character.isDigit(ch)) {
                // 読み込んだ文字が数字であった。
                // 数字が続く限り読み込んで、それを十進数とし解釈して
                // long値に変換する。得られた値をスタックに積む。
                long num = 0;
                while (Character.isDigit(ch)) {
                    num = 10 * num + (ch - '0');
                    c = input.read();
                    ch = (char) c;
                }
                input.unread(c);
                stack.push(num);
            } else {
                long a, b;// 作業用の変数
                switch (ch) {
                case '+':// 加算
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case '-':// 減算
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case '*':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case '/':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case ' ':
                case '\t':
                case '\r':
                    break;
                default:
                    throw new IllegalArgumentException("不正な文字" + ch + "がありました。");
                }
            }
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalAccessError("式がありません。");
        }
    }
}
