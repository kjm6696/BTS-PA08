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

    public Node delete(Node root, int index) {
        if (this.root != null) { // if root is not empty
            if (index < root.data) { // if item wanted to delete is on left side of tree
                root.left = delete(root.left, index); //keep running delete method until items is found
            } else if (index > root.data) { // if item wanted to delete is on right side of tree
                root.right = delete(root.right, index); //keep running delete method until items is found
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

//    public String inOrderTraversal(){
//        return this.inOrderTraversal(this.root);
//    }
//    private String inOrderTraversal(Node current){
//        StringBuilder stringBuilder = new StringBuilder();
//
//        if (current != null) {
//
//            stringBuilder.append(this.inOrderTraversal(current.left));
//
//            stringBuilder.append(current.data);
//            stringBuilder.append(" ");
//
//            stringBuilder.append(this.inOrderTraversal(current.right));
//
//        }
//
//        return stringBuilder.toString();
//    }

}
