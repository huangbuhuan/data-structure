package data.strucure.tree;

/**
 * @author hbh
 * @version 1.0.0
 * @since 2017/5/7下午7:22
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T> {
        T t;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T t) {
            this(t, null, null);
        }

        BinaryNode(T t, BinaryNode<T> lt, BinaryNode<T> rt) {
            this.t = t;
            this.left = lt;
            this.right = rt;
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T t, BinaryNode<T> node) {
        if (t == null) {
            return false;
        }

        int result = t.compareTo(node.t);
        if (result < 0) {
            return contains(t, node.left);
        } else if (result > 0) {
            return contains(t, node.right);
        }
        return true;
    }

    public boolean contains(T t) {
        return contains(t, root);
    }

    public BinaryNode<T> findMin() {
        return findMin(root);
    }

    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    public BinaryNode<T> findMax() {
        return findMax(root);
    }

    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t;
        }
        return findMax(t.right);
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<T>(t, null, null);
        }

        int result = t.compareTo(node.t);

        if (result < 0) {
            node.left = insert(t, node.left);
        } else if (result > 0) {
            node.right = insert(t, node.right);
        }
        return node;
    }

    public void remove(T t) {
        remove(t, root);
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null) {
            return node;
        }

        int result = t.compareTo(node.t);

        if (result < 0) {
            node.left = remove(t, node.left);
        } else if (result > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {
            node.t = findMin(node.right).t;
            node.right = remove(node.t, node.right);
        } else {
            node = node != null ? node.left : node.right;
        }
        return node;


    }

}
