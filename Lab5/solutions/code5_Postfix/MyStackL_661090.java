package solutions.code5_Postfix;

public class MyStackL_661090 {
    public class Node {
        String value;
        Node next;

        public Node(String d) {
            value = d;
            next = null;
        }
    }
    
    private Node top;

    public MyStackL_661090() {
        top = null;
    }

    public void push(String d) {
        Node newNode = new Node(d);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        String value = top.value;
        top = top.next;
        return value;
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Top->");
        Node temp = top;
        while (temp != null) {
            sb.append(temp.value).append("->");
            temp = temp.next;
        }
        sb.append("Bottom");
        return sb.toString();
    }
}
