/**
 * 二分木
 * 
 * @author asaetsu
 *
 */
public class BinaryTreeNode {
    String label; // この節のラベル
    BinaryTreeNode left; // 左部分木
    BinaryTreeNode right; // 右部分木

    /**
     * 二分木の節を生成する
     * 
     * @param label
     * @param left
     * @param right
     */
    public BinaryTreeNode(String label, BinaryTreeNode left,
            BinaryTreeNode right) {
        super();
        this.label = label;
        this.left = left;
        this.right = right;
    }

    /**
     * 二分木を行きがけ順になぞる
     * 
     * @param p
     *            　なぞるべき二分木
     */
    static void traversePreorder(BinaryTreeNode p) {
        if (p == null) {
            return;
        }
        System.out.println("節" + p.label + "に立ち寄りました。");
        traversePreorder(p.left);
        traversePreorder(p.right);
    }

    /**
     * 二分木を通りがけ順になぞる
     * 
     * @param p
     *            　なぞるべき二分木
     */
    static void traverseInorder(BinaryTreeNode p) {
        if (p == null) {
            return;
        }
        traverseInorder(p.left);
        System.out.println("節" + p.label + "に立ち寄りました。");
        traverseInorder(p.right);
    }

    /**
     * 二分木を帰りがけ順でなぞる
     * 
     * @param p
     */
    static void traversePostorder(BinaryTreeNode p) {
        if (p == null) {
            return;
        }
        traversePostorder(p.left);
        traversePostorder(p.right);
        System.out.println("節" + p.label + "に立ち寄りました。");
    }
}
