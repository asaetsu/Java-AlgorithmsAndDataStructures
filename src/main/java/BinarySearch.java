public class BinarySearch {

    static private class Entry {

        int key; // 比較の対象となるキー
        Object data; // それ以外の情報

        /*
         * エントリを生成する
         * 
         * @param key キー
         * 
         * @param data キーに対応するデータ
         */
        private Entry(int key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    final static int MAX = 100;// データの最大個数
    Entry[] table = new Entry[MAX];
    int n = 0;

    /*
     * キーkeyに対応するデータを探す
     * 
     * @param key キー
     * 
     * @return キーkeyに対応するデータ。キーが見つからなければnullを返す
     */
    public Object search(int key) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == table[middle].key)
                return table[middle].data;
            else if (key < table[middle].key)
                high = middle - 1;
            else
                low = middle + 1;
        }
        return null;
    }

    // public void add(int key, Object data) {
    // if(n == 0){
    // table[0] = new Entry(key, data);
    // }
    // int pos = 0;
    //
    //
    //
    // // pos = データを挿入すべき位置
    // // 配列中のposより後ろの要素を１つずつ後ろにずらす
    // table[pos] = new Entry(key, data);
    // }
}
