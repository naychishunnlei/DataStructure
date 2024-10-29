package tree;

public class Node {
	int data;
	Node left, right;
	int height;
	
	public Node(int key, int height) {
		this.data = key;
		this.height = height;
		this.left = null;
		this.right = null;
	}
	
	public Node(int key) {
		this(key, 1);
	}

}
