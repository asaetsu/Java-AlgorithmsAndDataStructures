/**
 * @author asaetsu 双方向リストのセル
 *
 */
public class CellDouble {
    CellDouble prev; // 前のセルへのリンク
    CellDouble next; // 次のセルへのリンク
    Object data; // このセルが持つデータ

    /**
     * セルを生成する
     * 
     * @param data
     *            　このセルが持つデータ
     */
    CellDouble(Object data) {
        prev = next = null;
        this.data = data;
    }
}
