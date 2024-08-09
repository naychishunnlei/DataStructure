package solutions.code5_Postfix;

public class MyQueueL_661090<T> {
    public MyQueueL_661090() {
        this.front = null;
        this.rear = null;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;

    // Enqueue: add an element to the end of the queue
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue: remove and return the element from the front of the queue
    public T dequeue() {
        if (front == null) {
            return null; // Queue is empty
        }
        T value = front.value;
        front = front.next;
        if (front == null) {
            rear = null; // If the queue becomes empty
        }
        return value;
    }

    // Peek: return the element at the front of the queue without removing it
    public T peek() {
        return (front == null) ? null : front.value;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Convert the queue to a string representation
    public String dumpToString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = front;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}
