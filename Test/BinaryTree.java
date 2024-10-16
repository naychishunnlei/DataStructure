class BinaryTree {
    Node root;

    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void inOrder() {
        System.out.println();
        System.out.print("InOrder: ");
        inOrderRec(root);
    }


    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + ", ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        System.out.println();
        System.out.print("PreOrder: ");
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if(root != null) {
            System.out.print(root.data + ", ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        System.out.println();
        System.out.print("Post-Order: ");
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if(root != null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + ", ");
        }
    }

    //delete, getMin, getMax

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert elements into the tree
        tree.insert(8);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);

        // Perform in-order traversal
        tree.inOrder(); // Expected output: 2, 5, 7, 8, 12, 15
        tree.preOrder();
        tree.postOrder();
    }
}
