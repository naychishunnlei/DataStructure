package solutions.pack9_Heap;

public class MyHeapSort extends MyMinHeap_661090{
    public String sort() {
        StringBuilder sorted = new StringBuilder();
        while (!isEmpty()) {
            sorted.append(remove()).append(" ");
        }
        return sorted.toString().trim();
    }
}
