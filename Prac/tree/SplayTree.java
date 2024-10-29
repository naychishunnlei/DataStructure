package tree;

public class SplayTree{
    private Node root;
    
    private Node leftRotate(Node x){
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }
    
    private Node rightRotate(Node x){
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }
    
    private Node splay(Node root, int key) {
        if(root == null || root.data == key) return root;
        
        if(key < root.data){
            //Zig Zig
            if(key < root.left.data){
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            }
            //Zig Zag
            else if(key > root.left.data){
                root.left.right = splay(root.left.right, key);
                if(root.left.right != null){
                    root.left = leftRotate(root.left);
                }
            }
            return (root.left == null) ? root : rightRotate(root);
        }else {
            if(root.right == null) return root;
            
            //Zag Zag
            if(key > root.right.data){
                root.right =splay(root.right, key);
                root= leftRotate(root);
            }
            //Zag Zig
            else if (key < root.right.data){
                root.right.left = splay(root.right.left, key);
                if(root.right.left != null){
                    root.right = rightRotate(root.right);
                }
            }
            return (root.right == null) ? root: leftRotate(root);
        }
    }
    
    public void insert(int key){
        if(root == null){
            root = new Node(key);
            return;
        }
        
        root = splay(root, key);
        
        if(root.data == key) return;
        
        Node newNode = new Node(key);
        if(key < root.data){
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }
        root = newNode;
    }
    
    public boolean search(int key){
        root = splay(root, key);
        return root != null && root.data == key;
    }
    
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    // Pre-order traversal
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    // Post-order traversal
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    public static void main(String[] args) {
        SplayTree tree = new SplayTree();

        // Sample keys to insert
        int[] keys = {10, 20, 30, 40, 50};

        for (int key : keys) {
            tree.insert(key);
        }

        System.out.println("In-order traversal:");
        tree.inOrder(); // Output: 10 20 30 40 50
        System.out.println("\nPre-order traversal:");
        tree.preOrder(); // Output: 30 20 10 40 50
        System.out.println("\nPost-order traversal:");
        tree.postOrder(); // Output: 10 20 50 40 30

        // Searching for a key
        int searchKey = 20;
        System.out.println("\nSearching for " + searchKey + ": " + (tree.search(searchKey) ? "Found" : "Not Found"));
    }
}