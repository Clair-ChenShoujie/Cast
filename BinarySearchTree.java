package ADTBinarySearchTree;

/**
 * Implement operations on the other tree node and root node
 * @author Junyu Sun
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> extends BaseBinarySearchTree<T> {

    /**
     * Create a empty root node
     */
    protected TreeNode<T> root;

    /**
     * Creates an empty  binary tree.
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Creates a one node binary tree.
     * @param element The contents of the root node
     */
    public BinarySearchTree(T element) {
        super(element);
    }

    /**
     * Find the specified tree node in the search binary tree.
     * @param element The contents of the node you want to find
     * @return the tree node
     */
    public TreeNode<T> search(T element) {
        if (root == null) {
            return null;
        } else {
            return root.search(element);
        }
    }

    /**
     * Add new nodes to the tree in a certain order
     * @param node the tree node need to add
     */
    public void insert(TreeNode<T> node) {
        if (root == null) {
            root = node;
        } else {
            root.insert(node);
        }
    }

    /**
     * Delete a node in the tree
     * @param element The contents of the node you want to delete
     */
    public void delete(T element) {
        if (root == null) {
            return;
        } else {
            root.delete(element, root);
        }
    }

    public TreeIterator Construct(){
        TreeIterator treeIterator = new TreeIterator<>(this);
        return treeIterator;
    }

}

