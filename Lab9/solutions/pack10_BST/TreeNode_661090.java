package solutions.pack10_BST;

public class TreeNode_661090 {
    int data;
    TreeNode_661090 left, right, parent;

    public TreeNode_661090(int d) {
        data = d;
    }

    @Override
    public String toString() {
        //no child
        if(left == null && right == null) {
            return "null<-" + data + "->null";
        }

        else if(left != null && right == null) {
            return left.data + "<-" + data + " ->null";
        }

        else if(left == null && right != null) {
            return "null<-" + data + "->" + right.data;
        }

        else {
            return left.data + "<-" + data + "->" + right.data;
        }
    }
}
