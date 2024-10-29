package tree;

public class BinaryTree {
	 private Node root;
	    
	    public void insert(int key){
	        root = insertRec(root, key);
	    }
	    
	    private Node insertRec(Node root, int key){
	        if(root == null){
	            root = new Node(key);
	            return root;
	        }
	        if(key < root.data){
	            root.left = insertRec(root.left, key);
	        } else if(key > root.data){
	            root.right = insertRec(root.right, key);
	        }
	        return root;
	        
	    }
	    
	    public void inOrder(){
	        inOrderRec(root);
	    }
	    
	    private void inOrderRec(Node root){
	        if(root != null){
	            inOrderRec(root.left);
	            System.out.print(root.data+ ", ");
	            inOrderRec(root.right);
	        }
	    }
	    
	    public void preOrder(){
	        preOrderRec(root);
	    }
	    
	    private void preOrderRec(Node root){
	        if(root != null){
	            System.out.print(root.data + ", ");
	            preOrderRec(root.left);
	            preOrderRec(root.right);
	        }
	    }
	    
	    public void postOrder(){
	        postOrderRec(root);
	    }
	    
	    private void postOrderRec(Node root){
	        if(root != null){
	            postOrderRec(root.left);
	            postOrderRec(root.right);
	            System.out.print(root.data+ ", ");
	        }
	    }
	    
	    public boolean search(int key){
	        return searchRec(root, key);
	    }
	    
	    private boolean searchRec(Node root, int key){
	        if(root == null){
	            return false;
	        }
	        if(root.data == key){
	            return true;
	        }
	        return key<root.data ? searchRec(root.left, key) : searchRec(root.right, key);
	    }

	public static void main(String[] args) {
		 BinaryTree tree = new BinaryTree();
	        
	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);
	        
	        // Print traversals
	        System.out.println("In-order traversal:");
	        tree.inOrder(); // Output: 20 30 40 50 60 70 80
	        System.out.println("\nPre-order traversal:");
	        tree.preOrder(); // Output: 50 30 20 40 70 60 80
	        System.out.println("\nPost-order traversal:");
	        tree.postOrder(); // Output: 20 40 30 60 80 70 50
	        
	        // Search for a value
	        int searchKey = 60;
	        System.out.println("\nSearching for " + searchKey + ": " + (tree.search(searchKey) ? "Found" : "Not Found"));

	}

}
