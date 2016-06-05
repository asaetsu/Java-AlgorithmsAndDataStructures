/**
 * 二分探索
 * 
 * @author asaetsu
 *
 */
public class BinarySearchTree {
    private Node root; // 二分探索の根

    /**
     * 二分探索木を生成する
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * 二分探索木からキーkeyをもつ節を探索する
     * 
     * @param key
     *            　探しだすキー
     * @return　キーkeyをもった節が見つかればそれを返し、見つからなければnullを返す
     */
    public Node search(Integer key) {
        Node p = root;
        while (p != null) {
            int result = key.compareTo(p.data);
            if (result == 0) {
                return p;
            } else if (result < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 二分探索木にキーkeyをもつ節を挿入する
     * 
     * @param key
     *            　挿入するキー
     * @return　挿入したキーをもつ節へのリンクを返す。すでに登録されていればnullを返す
     */
    public Node insert(Integer key) {
        Node p = root;
        Node parent = null;
        boolean isLeftChild = false;

        while (p != null) {
            int result = key.compareTo(p.data);
            if (result == 0) {
                return null;
            } else if (result < 0) {
                parent = p;
                isLeftChild = true;
                p = p.left;
            } else {
                parent = p;
                isLeftChild = false;
                p = p.right;
            }
        }

        Node newNode = new Node(key);
        if (parent == null) {
            root = newNode;
        } else if (isLeftChild) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return newNode;
    }

    /**
     * 二分探索木から最小の要素を削除する
     * 
     * @param parent
     *            　pの親
     * @param p
     *            　二分探索木
     * @return　削除した節
     */
    private static Node deleteMin(Node parent, Node p) {
        boolean isLeftChild = false;
        while (p.left != null) {
            parent = p;
            isLeftChild = true;
            p = p.left;
        }

        if (isLeftChild) {
            parent.left = p.right;
        } else {
            parent.right = p.right;
        }
        return p;
    }

    /**
     * 二分探索木からキーkeyをもつ節を削除する
     * 
     * @param key
     *            　削除するキー
     * @return　削除に成功すればtrue, 要素が存在しなければfalseを返す
     */
    public boolean delete(Integer key) {
        Node p = root;
        Node parent = null;
        boolean isLeftChild = false;

        while (p != null) {
            int result = key.compareTo(p.data);
            if (result == 0) {
                if (p.left == null && p.right == null) {// 葉
                    if (parent == null) {
                        root = null;
                    } else if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (p.left == null) {// 右の子のみあり
                    if (parent == null) {
                        root = p.right;
                    } else if (isLeftChild) {
                        parent.left = p.right;
                    } else {
                        parent.right = p.right;
                    }
                } else if (p.right == null) {// 左の子のみあり
                    if (parent == null) {
                        root = p.left;
                    } else if (isLeftChild) {
                        parent.left = p.left;
                    } else {
                        parent.right = p.left;
                    }
                } else {// 両方あり
                    Node x = deleteMin(p, p.right);

                    if (parent == null) {
                        root = x;
                    } else if (isLeftChild) {
                        parent.left = x;
                    } else {
                        parent.right = x;
                    }
                    x.right = p.right;
                    x.left = p.left;
                }
                return true;

            } else if (result < 0) {// 左
                parent = p;
                isLeftChild = true;
                p = p.left;
            } else {// 右
                parent = p;
                isLeftChild = false;
                p = p.right;
            }
        }
        return false;
    }

    private static void inorder(Node p) {
        if (p == null) {
            return;
        } else {
            inorder(p.left);
            System.out.println(p.data);
            inorder(p.right);
        }
    }

    public void showAll() {
        inorder(root);
    }
}
