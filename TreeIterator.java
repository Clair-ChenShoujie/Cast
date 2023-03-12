package ADTBinarySearchTree;

import java.util.LinkedList;
/**
 * Implement an Iterator of binary search tree
 * @author Junyu Sun
 * @version 1.0
 */
public class TreeIterator<T extends Comparable<T>> implements java.util.Iterator<T>{

    /**
     * The tree that this iterator needs to traverse
     */
    private BinarySearchTree tree;

    /**
     * An ordered list of nodes traversed by this iterator.
     */
    private LinkedList<TreeNode<T>> list;

    /**
     * Create an iterator on the binary search tree
     * @param tree a reference to binary search tree
     */
    public TreeIterator(BinarySearchTree tree){
        this.tree = tree;
        this.list = new LinkedList<TreeNode<T>>();

    }

    /**
     * Determine if the iteration has more elements.
     * @return A boolean value specifying if there is no element in the list
     */
    public boolean hasNext(){return !this.list.isEmpty();}

    /**
     * Returns the value of the last digit in the linked list and removes the last bit
     * @return the value of the last digit in the linked list
     * @throws java.util.NoSuchElementException
     */
    public T next() throws java.util.NoSuchElementException{
        return this.list.remove().getElement();
    }

    /**
     * Remove the element of iterator next ().
     * @throws UnsupportedOperationException
     */
    public void remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    /**
     * Traverse the nodes in the tree in the foresequence.
     */
    public void setPreorder(){
        this.list.clear();
        this.preorder(this.tree.root);
    }

    /**
     * Traverse the nodes in the tree in the middle order
     */
    public void setInorder(){
        this.list.clear();
        this.inorder(this.tree.root);
    }

    /**
     * Traverse the nodes in the tree in the post order
     */
    public void setPostorder(){
        this.list.clear();
        this.preorder(this.tree.root);
    }

    /**
     * Add the nodes of the tree to the linked list in the preceding order
     * @param treeNode the node of the binary search tree.
     */
    private void preorder(TreeNode<T> treeNode){
        if(treeNode != null){
            this.list.add(treeNode);
            preorder(treeNode.getLeft());
            preorder(treeNode.getRight());
        }
    }

    /**
     * Add the nodes of the tree to the linked list in the middle order
     * @param treeNode the node of the binary search tree.
     */
    public void inorder(TreeNode<T> treeNode){
        if(treeNode != null){
            inorder(treeNode.getLeft());
            this.list.add(treeNode);
            inorder(treeNode.getRight());
        }
    }

    /**
     * Add the nodes of the tree to the linked list in the post order
     * @param treeNode the node of the binary search tree.
     */
    public void postorder(TreeNode<T> treeNode){
        if(treeNode != null){
            postorder(treeNode.getLeft());
            postorder(treeNode.getRight());
            this.list.add(treeNode);
        }
    }
}
