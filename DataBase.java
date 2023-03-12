package ADTBinarySearchTree;

import java.util.LinkedList;
/**
 * Implement the data base
 * @author Junyu Sun
 * @version 1.0
 */
public class DataBase implements DataBaseInterface {

    /**
     * Create a binary search tree
     */
    BinarySearchTree<ClassSection> binarySearchTree = new BinarySearchTree();

    /**
     * The total number of class sections
     */
    private int num;

    /**
     * Create a default database by using binary search tree
     * @param binarySearchTree a binary search tree
     */
    public DataBase(BinarySearchTree<ClassSection> binarySearchTree){
        this.binarySearchTree = binarySearchTree;
    }

    /**
     * Add new course information to database
     * @param s1 the new course information
     */
    public void insert(ClassSection s1){
        TreeNode<ClassSection> node = new TreeNode<ClassSection>();
        node.setElement(s1);
        if(binarySearchTree.root == null){
            binarySearchTree.root = node;
            num++;
        }else{
            binarySearchTree.insert(node);
            num++;
        }
    }

    /**
     * Delete the course information form database
     * @param s1 the course information
     */
    public void delete(ClassSection s1){
        binarySearchTree.delete(s1);
    }

    /**
     * Find the course information form database
     * @param s1 the course information
     * @return the tree node
     */
    public TreeNode search(ClassSection s1){
        return binarySearchTree.search(s1);
    }

    /**
     * Determine if the binary search tree is empty
     * @return a boolean value
     */
    public boolean isEmpty(){
        return binarySearchTree.root == null;
    }

    /**
     * Make the tree empty
     */
    public void makeEmpty(){
        binarySearchTree.root = null;
    }

    /**
     * Sort the nodes of this tree: traverse this class database in an inorder traversal
     * @return a reference to linked list
     */
    public LinkedList<ClassSection> sort(){

        LinkedList<ClassSection> list = new LinkedList<ClassSection>();

        TreeIterator<ClassSection> iterator = new TreeIterator<>(binarySearchTree);

        iterator.inorder(binarySearchTree.root);

        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * The total number of class sections
     * @return the total number of class sections
     */
    public int size(){
        return num;
    }

}

