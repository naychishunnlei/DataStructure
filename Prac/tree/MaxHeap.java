package tree;

import java.util.Arrays;

public class MaxHeap {
	private int[] heap;
    private int size;
    private int capacity;
    
    public MaxHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    
    private int parent(int index){
        return (index - 1)/2;
    }
    
    private int leftChild(int index){
        return 2 * index + 1;
    }
    
    private int rightChild(int index){
        return 2 * index + 2;
    }
    
    public void insert(int key){
        if(size == capacity){
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = key;
        size++;
        heapifyUp(size - 1); //index of the last element added
    }
    
    private void heapifyUp(int index){
        while(index != 0 && heap[parent(index)] < heap[index]){ // > for minHeap
            swap(index, parent(index));
            index = parent(index);
        }
    }
    
    public int deleteMax(){
        if(size <= 0){
            throw new IllegalStateException("Heap is empty.");
        }
        if(size == 1){
            size--;
            return heap[0];
        }
        
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }
    
    private void heapifyDown(int index){
        int largest = index; //smallest for min
        int left = leftChild(index);
        int right = rightChild(index);
        
        if(left < size && heap[left] > heap[largest]){// < for min
            largest = left;
        }
        if(right < size && heap[right] > heap[largest]){// < for min
            largest = right;
        }
        if(largest != index){
            swap(index, largest);
            heapifyDown(largest);
        }
    }
    
    private void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    
    public int peek(){
        if(size == 0){
            throw new IllegalStateException("Heap is empty.");
        }
        return heap[0];
    }
    
    public void display(){
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }
    
    public void printHeap() {
        for(int i=0; i < size; i++){
            System.out.print(heap[i]+ " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(8);
        maxHeap.insert(4);

        System.out.println("Max Heap: ");
        maxHeap.display();

        System.out.println("Maximum element: " + maxHeap.peek());

        System.out.println("Deleted maximum: " + maxHeap.deleteMax());
        System.out.println("Max Heap after deletion: ");
        maxHeap.display();
    }

}
