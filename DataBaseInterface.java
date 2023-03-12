package ADTBinazrySearchTree;

import java.util.LinkedList;
/**
 * Implement the data base
 * @author Junyu Sun
 * @version 1.0
 */
public interface DataBaseInterface {

    /**
     * Add new course information to database
     * @param element the new course information
     */
    void insert(ClassSection element);

    /**
     * Delete the course information form database
     * @param element the course information
     */
    void delete (ClassSection element);

    /**
     * Find the course information form database
     * @param element the course information
     * @return the tree node
     */
    TreeNode<ClassSection> search(ClassSection element);

    /**
     * Determine if the binary search tree is empty
     * @return a boolean value
     */
    boolean isEmpty();

    /**
     * Make the tree empty
     */
    void makeEmpty();

    /**
     * Sort the nodes of this tree: traverse this class database in an inorder traversal
     * @return a reference to linked list
     */
    LinkedList<ClassSection> sort();
}
