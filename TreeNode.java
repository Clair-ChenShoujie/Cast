package ADTBinarySearchTree;

/**
 * Implement an tree node of a binary search tree
 * @author Junyu Sun
 * @version 1.0
 */
class TreeNode<T extends Comparable<T>> {

    /**
     * The contents of the node
     */
    protected T element;

    /**
     * The left child node of the node
     */
    private TreeNode<T> left;

    /**
     * The right child node of the node
     */
    private TreeNode<T> right;

    /**
     * Get the content of the node
     * @return the content of the node
     */
    public T getElement() {
        return element;
    }

    /**
     * Set the content of the node
     * @param element the new content of this node
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Set the right child node of this node
     * @param right the tree node
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Set the left child node of this node
     * @param left the tree node
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Get the left child node of this node
     * @return the left child node of this node
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Get the right child node of this node
     * @return the right child node of this node
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Print the content of the node
     * @return the content of the node
     */
    public String toString(){
        return"element: " + element ;
    }


    /**
     * Find the specified tree node in the search binary tree.
     * @param element The contents of the node you want to find
     * @return the tree node
     */
    public TreeNode<T> search(T element){
        if(element.compareTo((T)this.element) == 0){
            return this;
        }else if(element.compareTo((T)this.element) < 0){
            if(this.left == null){
                return null;
            }
            return this.left.search(element);
        }else{
            if(this.right == null)
                return null;
            return this.right.search(element);
        }
    }

    /**
     * Add new nodes to the tree in a certain order
     * @param node the tree node need to add
     */
    public void insert(TreeNode<T> node){
        if(node == null){
            return;
        }
        if(node.getElement().compareTo((T)this.getElement()) < 0){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.insert(node);
            }

        }else{
            if(this.right == null){
                this.right = node;
            }else{
                this.right.insert(node);
            }
        }
    }


    /**
     * Find the parent node of the node that you want to delete
     * @param element the content of the node that you want to delete
     * @return the parent node of the node that you want to delete
     */
    public TreeNode<T> searchParent(T element){
        if((this.left != null && this.left.getElement().compareTo(element) == 0) || (this.right != null &&this.right.getElement().compareTo(element) == 0)){
            return this;
        }else{
            if(element.compareTo(this.getElement()) < 0 && this.left != null){
                return this.left.searchParent(element);
            }else if(element.compareTo(this.getElement()) > 0 && this.right != null){
                return this.right.searchParent(element);
            }else{
                return null;
            }
        }
    }

    /**
     * Delete a node in the tree
     * @param element The contents of the node you want to delete
     */
    public void delete(T element, TreeNode<T> root){
        if(root == null){
            return;
        }else{
            //Locate the node that you want to delete
            TreeNode<T> targetNode = search(element);
            if(targetNode == null){
                return;
            }
            //The node to delete is the root node
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
            //Locate the parent node of the node that you want to delete
            TreeNode<T> parent = searchParent(element);
            //The node to delete is a leaf node
            //Determine where on the parent node the node to delete is
            if(targetNode.left == null && targetNode.right == null){
                if(parent.left != null && parent.left.getElement().compareTo(element) == 0){
                    parent.left = null;
                }else if(parent.right != null && parent.right.getElement().compareTo(element) == 0){
                    parent.right = null;
                }
            //The node to delete is a node with two subtrees
            //Find the minimum value in the right subtree of this node
            //Replace the value to delete the node with the minimum value
            }else if(targetNode.left != null && targetNode.right != null){
                T minValue = root.delRightTreeMin(targetNode.right,root);
                targetNode.setElement(minValue);
            }else{
                //The node to be deleted is a node with only one subtree
                if(targetNode.left != null){
                    if(parent != null){
                        if(parent.left.getElement().compareTo(element) == 0){
                            parent.left = targetNode.left;
                        }else{
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else{
                    if(parent != null){
                        if(parent.left.getElement().compareTo(element) == 0){
                            parent.left = targetNode.right;
                        }else{
                            parent.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * Find the smallest value among the nodes of the subtree
     * @param node the node that you want to delete
     * @param root the root node of the binary search tree
     * @return the smallest value
     */
    public T delRightTreeMin(TreeNode<T> node, TreeNode<T> root){
        TreeNode<T> target = node;
        while(target.left != null){
            target = target.left;
        }
        delete(target.getElement(),root);
        return target.getElement();
    }


}
