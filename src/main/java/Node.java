/**
 * 二分探索木の節
 * 
 * @author asaetsu
 */
public class Node {
    Integer data; // この節のラベル
    Node left; // 左部分木
    Node right; // 右部分木

    Node(Integer data) {
        left = null;
        right = null;
        this.data = data;
    }
}
