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
        if (this.root != null) {
            if (index < root.data) {
                root.left = delete(root.left, index);
            } else if (index > root.data) {
                root.right = delete(root.right, index);
            } else {
                if (root.right == null && root.left == null) {
                    root.data = null;
                } else if (root.right != null) {
                    root.data = null;
                    root.data = root.right.data;
                    root.right.data = null;
                } else if (root.left != null){
                    root.data = null;
                    root.data = root.left.data;
                    root.left.data = null;
                }
            }
        }
        return root;
    }

    public String inOrderTraversal(){
        return this.inOrderTraversal(this.root);
    }
    private String inOrderTraversal(Node current){
        StringBuilder stringBuilder = new StringBuilder();

        if (current != null) {

            stringBuilder.append(this.inOrderTraversal(current.left));

            stringBuilder.append(current.data);
            stringBuilder.append(" ");

            stringBuilder.append(this.inOrderTraversal(current.right));

        }

        return stringBuilder.toString();
    }

}
