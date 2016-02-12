public class LinearSearch {

    /*
     * テーブルのエントリ
     */
    static private class Entry {
        int key; // 比較の対象となるキー
        Object data; // それ以外の情報

        private Entry(int key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    final static int MAX = 100; // データの最大個数
    Entry[] table = new Entry[MAX]; // データを格納する配列
    int n = 0; // tableに登録されているデータの個数

    /*
     * データを登録する
     * 
     * @param key　キー
     * 
     * @param data　キーに対応するデータ
     */
    public void add(int key, Object data) {
        if (n >= MAX) {
            throw new IllegalStateException("データの個数が多すぎます。");
        }
        table[n++] = new Entry(key, data);
    }

    /*
     * キーkeyに対応するデータを探す
     * 
     * @param key キー
     * 
     * @return キーに対応するデータ。キーが見つからなければnullを返す
     */
    public Object search(int key) {
        int i = 0;
        while (i < n) {
            if (table[i].key == key)
                return (table[i].data);
            i++;
        }
        return null;
    }
}
