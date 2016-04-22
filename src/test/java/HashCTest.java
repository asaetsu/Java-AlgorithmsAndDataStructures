import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HashCTest {

    HashC c;
    MyKey key1;
    String[] words;

    @Before
    public void setUp() {
        c = new HashC();
        words = new String[] { "one", "two", "three", "four", "five", "one",
                "six", "seven", "eight", "nine", "ten" };
    }

    @Ignore
    @Test
    public void test() {
        for (int i = 0, len = words.length; i < len; i++) {
            if (c.insert(new MyKey(words[i]), "登録順： " + (i + 1))) {
                System.out.println("☆☆☆ 登録成功： " + (i + 1) + "番目　" + words[i]);
            } else {
                System.out.println("★★★ 登録失敗： 既に同じキーのデータが登録されています．　" + (i + 1)
                        + "番目　" + words[i]);
            }
        }

        System.out.println("◆ 検索");
        String[] keys1 = new String[] { "ten", "one" };
        String result;
        for (int i = 0, len = keys1.length; i < len; i++) {
            MyKey m = new MyKey(keys1[i]);
            result = (String) c.find(m);
            if (result != null) {
                System.out.println("☆☆☆ 検索成功： [key: " + keys1[i] + ", data: "
                        + result + "]");
            } else {
                System.out.println("★★★ 検索失敗：見つかりませんでした．　[key: " + keys1[i]
                        + "]");
            }
        }

        // 削除
        System.out.println("◆ 削除");
        String[] keys2 = new String[] { "ten", "tens" };
        for (int i = 0, len = keys2.length; i < len; i++) {
            if (c.delete(new MyKey(keys2[i]))) {
                System.out.println("☆☆☆ 削除成功： [key: " + keys2[i] + "]");
            } else {
                System.out.println("★★★ 削除失敗：キーが登録されていません．．　[key: " + keys2[i]
                        + "]");
            }
        }
    }
}
