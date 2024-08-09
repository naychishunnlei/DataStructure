package solutions.code5_Postfix;

import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueListWrap_661090<T> implements Iterable<T> {
    private LinkedList<T> items = new LinkedList<>();

    // Enqueue: add an element to the end of the queue
    public void enqueue(T value) {
        items.addLast(value);
    }

    // Dequeue: remove and return the element from the front of the queue
    public T dequeue() {
        return items.pollFirst();
    }

    // Peek: return the element at the front of the queue without removing it
    public T peek() {
        return items.peekFirst();
    }

    public T getLast() {
        return items.peekLast();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Provide a string representation of the queue's elements
    public String dumpToString() {
        StringBuilder sb = new StringBuilder();
        for (T item : items) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }

    // Implementing the Iterable interface
    @Override
    public Iterator<T> iterator() {
        return new MyQueueIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<T> iter = items.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Inner class to implement the Iterator interface
    private class MyQueueIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < items.size();
        }

        @Override
        public T next() {
            return items.get(currentIndex++);
        }
    }
}
