/**
 * @author asaetsu 位置
 */
public class Position {

    private int x;// x座標
    private int y;// y座標

    /**
     * 位置を生成する
     * 
     * @param x
     *            x座標
     * @param y
     *            y座標
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * x方向にxDeltaだけ移動する
     * 
     * @param xDelta
     *            x方向への移動量
     */
    public void moveX(int xDelta) {
        x += xDelta;
    }

    /**
     * y方向にyDeltaだけ移動する
     * 
     * @param yDelta
     *            　y方向への移動量
     */
    public void moveY(int yDelta) {
        y += yDelta;
    }

    /**
     * x方向にxDelta、y方向にyDelta移動する
     * 
     * @param xDelta
     *            　x方向への移動量
     * @param yDelta
     *            　y方向への移動量
     */
    public void moveXY(int xDelta, int yDelta) {
        x += xDelta;
        y += yDelta;
    }

    /**
     * x座標を得る
     * 
     * @return　x
     */
    public int getX() {
        return x;
    }

    /**
     * y座標と得る
     * 
     * @return
     */
    public int getY() {
        return y;
    }

    /*
     * 位置を表す文字列を返す
     * 
     * @return 位置を表す文字列
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /*
     * ハッシュ値を求める
     * 
     * @return このオブジェクトのハッシュ値を返す
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + x;
        result = result * 31 + y;
        return result;
    }
}
