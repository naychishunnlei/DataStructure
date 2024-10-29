package tree;

public class AVLTree {
    private Node root;
    
    private int height(Node node){
        if(node == null) return 0;
        return node.height;
    }
    
    private int getBalance(Node node) {
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }
    
    //right rotate
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        
        x.right = y;
        y.left = T2;
        
        y.height = Math.max(height(y.left), height(y.right))+ 1;
        x.height = Math.max(height(x.left), height(x.right))+ 1;
        
        return x;
        
    }
    
    //left rotate
    private Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;
        
        y.left = x;
        x.right = T2;
        
        y.height = Math.max(height(y.left), height(y.right))+ 1;
        x.height = Math.max(height(x.left), height(x.right))+ 1;
        
        return y;
        
    }
    
    public void insert(int key) {
        root = insertNode(root, key);
    }
    
    private Node insertNode(Node node, int key) {
        //normal BST
        if(node == null) return new Node(key);
        
        if(key < node.data){
            node.left = insertNode(node.left, key);
        }else if(key > node.data){
            node.right = insertNode(node.right, key);
        } else {
            return node;
        }
        
        node.height= Math.max(height(node.left), height(node.right))+ 1;
        
        int balance = getBalance(node);
        
        //Left Left case
        if(balance > 1 && key < node.left.data){
            return rightRotate(node);
        }
        
        //Right Right case
        if(balance < -1 && key > node.right.data) {
            return leftRotate(node);
        }
        
        //Left Right case
        if(balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        //Right Left case
        if(balance < -1 && key < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }
    
    private void inOrderRec(Node node) {
        if(node != null){
            inOrderRec(node.left);
            System.out.print(node.data + ", ");
            inOrderRec(node.right);
        }
       
    }
    
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }
    
    private void preOrderRec(Node node) {
        if(node != null){
            System.out.print(node.data + ", ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
        
    }
    
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }
    
    private void postOrderRec(Node node) {
        if(node != null){
            System.out.print(node.data + ", ");
            postOrderRec(node.left);
            postOrderRec(node.right);
        }
        
    }
    
    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        // Sample keys to insert
        int[] keys = {10, 20, 30, 40, 50, 25};

        for (int key : keys) {
            tree.insert(key);
        }

        System.out.println("In-order traversal:");
        tree.inOrder(); // Output: 10 20 25 30 40 50

        System.out.println("Pre-order traversal:");
        tree.preOrder(); // Output: 30 20 10 25 40 50

        System.out.println("Post-order traversal:");
        tree.postOrder(); // Output: 10 25 20 50 40 30
    }
}
