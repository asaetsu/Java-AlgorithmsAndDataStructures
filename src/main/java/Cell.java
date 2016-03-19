/**
 * 連結リストのセル
 * 
 * @author asaetsu
 *
 */
public class Cell {
    Cell next; // 次のセルへのリンク
    Object data; // このセルがもつデータ

    /**
     * セルを生成する
     * 
     * @param data
     *            　このセルがもつデータ
     */
    Cell(Object data) {
        next = null;
        this.data = data;
    }
}
