package solutions.pack10_BST;

import java.util.ArrayList;
import java.util.List;

public class BST_661090 {
    TreeNode_661090 root;
    public BST_661090() { root = null; }

    public TreeNode_661090 getRoot() {
        return root;
    }

    public void insert(int d) {
        if(root == null) {
            root = new TreeNode_661090(d);
            return;
        }
        TreeNode_661090 current = root;
        while (current != null) {
            if(d < current.data) {
                if (current.left!= null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode_661090(d);
                    current.left.parent = current;
                    return;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode_661090(d);
                    current.right.parent = current;
                    return;
                }
            }
        }
    }

    public TreeNode_661090 search(int d) {
        return searchRecurse(d, root);
    }

    private TreeNode_661090 searchRecurse(int d, TreeNode_661090 node) {
        if (node == null) return null;
        if(d == node.data) return node;
        if(d < node.data)
            return searchRecurse(d, node.left);
        return searchRecurse(d, node.right);
    }
    public void delete(int d) {
        root= delete(d, root);
    }

    private TreeNode_661090 delete(int d, TreeNode_661090 node) {
        if(node == null) return null;
        if(d < node.data)
            node.left = delete(d, node.left);
        else if(d > node.data)
            node.right = delete(d, node.right);
        else {
            if((node.left == null) || (node.right == null)) {
                TreeNode_661090 q = (node.left == null) ?node.right:node.left;
                if(q != null) {
                    q.parent = node.parent;
                }
                return q;
            } else {
                TreeNode_661090 q = findMaxFrom(node.left);
                node.data = q.data;
                node.left = delete(q.data, node.left);
            }
        }
        return node;
    }

    private TreeNode_661090 findMaxFrom(TreeNode_661090 node) {
        if(node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
        System.out.println();
    }

    private void printPreOrderRecurse(TreeNode_661090 node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrderRecurse(node.left);
        printInOrderRecurse(node.right);
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
        System.out.println();
    }

    private void printPostOrderRecurse(TreeNode_661090 node) {
        if(node == null) return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.print(node.data + " ");
    }

    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }

    private void printInOrderRecurse(TreeNode_661090 node) {
        if (node == null) return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }

    public TreeNode_661090 findMin() {
        if (root == null) return null;
        
        TreeNode_661090 current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public TreeNode_661090 findMax() {
        if (root == null) return null;

        TreeNode_661090 current = root;
        while(current.right != null) {
            current = current.right;
        }
        return current;
    }


    public int height() {
        return height(root);
    }
    
    private int height(TreeNode_661090 node) {
        if (node == null) return -1;
    
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
    
        return 1 + Math.max(leftHeight, rightHeight);
    }
    

    public int count() {
        return count(root);
    }
    
    private int count(TreeNode_661090 node) {
        if (node == null) return 0;
    
        int leftCount = count(node.left);
        int rightCount = count(node.right);
    
        return 1 + leftCount + rightCount;
    }

    public double findMedian() {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);

        int size = sortedList.size();
        if (size == 0) return 0.0;

        if (size % 2 == 1) {
            return sortedList.get(size/2);
        } else {
            return (sortedList.get(size / 2 - 1) + sortedList.get(size / 2)) / 2.0;
        }
    }

    public int findRank(int value) {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);

        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) == value) {
                return i+1;
            }
        }
        return -1;
    }

    private void inOrderTraversal(TreeNode_661090 node, List<Integer> list) {
        if (node == null) return;
        inOrderTraversal(node.left, list);
        list.add(node.data);
        inOrderTraversal(node.right, list);
    }
    
}
