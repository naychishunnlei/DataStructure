package solutions.pack9_Heap;

public class MyPriorityQueue_661090 implements MyQueueInterface_661090 {
    MyMinHeap_661090 heap = new MyMinHeap_661090();

    public void enqueue(int d) {
        heap.insert(d);
    }

    public int dequeue() {
        return heap.remove();
    }

    public int front() {
        return heap.peek();
    }

    public boolean isFull() {
        return heap.isFull();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
