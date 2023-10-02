import java.util.ArrayList;

public class BinarySearchTree {
    protected Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(Integer data) {
        this.root = this.insert(this.root, data);
    }

    private Node insert(Node current, Integer data) {
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data){
            current.left = this.insert(current.left, data);
        } else if (data > current.data) {
            current.right = this.insert(current.right, data);
        }
        return current;
    }

    public Node delete(Node root, int data) {
        if (this.root != null) { // if root is not empty
            if (data < root.data) { // if item wanted to delete is on left side of tree
                root.left = delete(root.left, data); //keep running delete method until items is found
            } else if (data > root.data) { // if item wanted to delete is on right side of tree
                root.right = delete(root.right, data); //keep running delete method until items is found
            } else { // item found now delete
                if (root.right == null && root.left == null) { // if desired item has no children
                    root.data = null; // delete node
                } else if (root.right != null) { // if item has child on right (bigger)
                    root.data = root.right.data;// child now takes parents spot
                    root.right.data = null; // updated child spot to null
                } else{ //if item has child on left (smaller but has no siblings)
                    root.data = root.left.data; // child now takes parents spot
                    root.left.data = null;// update child spot to null
                }
            }
        }
        else { // if root == null
            throw new IllegalArgumentException(); // throw exception
        }
        return root;// return the new BST
    }
    public boolean contains(int data) {
        if (this.root != null) { // if bst is not empty
            if(data != root.data) { // if data != the root number
                if (data < root.data) { // if data is on left side
                    return data == root.left.data; // return true if data == left child
                } else { // if data is on right side
                    return data == root.right.data; // return true if data == right child
                }
            } else { // if data == root (parent) return true
                return true;
            }
        }
        return false; // if not in the bst return false
    }

    public Node rebalance(){
        return this.rebalance(this.root);
    }

    public Node rebalance(Node root){
        ArrayList<Integer> balanced = new ArrayList<>();
        if (this.root != null) {
            if (root.left != null) {
                root = root.left;
                root = rebalance(root);
            } else if (root.right != null) {
                root = root.right;
                root.right = rebalance(root.right);
            }
        }
        return root;
    }

}

