package ADTBinarySearchTree;

import Iterator.TreeException;
/**
 * Implement operations on the root node
 * @author Junyu Sun
 * @version 1.0
 */
public class BaseBinarySearchTree<T extends Comparable<T>>{
    /**
     * The root of this tree
     */
    protected TreeNode<T> root;

    /**
     * Construct an empty binary search tree.
     */
    public BaseBinarySearchTree(){
        this.root = null;
    }

    /**
     * Construct a tree with only the root node
     * @param element The contents of the root node
     */
    public BaseBinarySearchTree(T element){
        this.root.element = element;
    }


    /**
     * Gets the root node of the tree
     * @return The contents of the root node
     * @throws TreeException Determine whether the tree is empty
     */
    public T getRoot() throws TreeException {
        if(this.root == null){
            throw new TreeException("Empty tree");
        }else{
            return this.root.getElement();
        }
    }

    /**
     * Change the root node of the tree
     * @param element The contents of the root node
     */
    public void setRoot(T element){
        this.root.element = element;
    }

    /**
     * Determine if tree is empty
     * @return a boolean value
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Make the tree empty
     */
    public void makeEmpty(){
        this.root = null;
    }
}
