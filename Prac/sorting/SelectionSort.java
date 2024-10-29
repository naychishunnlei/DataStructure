package sorting;

import java.util.Arrays;

public class SelectionSort {

    private int[] numbers;
    private int size; // Current number of elements in the array

    // Constructor to initialise the array with a specific capacity
    public SelectionSort(int capacity) {
        numbers = new int[capacity];
        size = 0; // Start with no elements
    }

    // Method to perform Selection Sort
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    // Method to swap two elements in the array
    private void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    // Method to print the array
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
    }

    // Method to insert an element into the array
    public void insert(int value) {
        // Check if the array is full and resize it
        if (size == numbers.length) {
            resize(numbers.length * 2); // Double the array size
        }
        numbers[size] = value; // Add the new value at the end
        size++; // Increment the size
        System.out.println(value + " inserted into the array.");
    }

    // Method to delete an element from the array at a specific index
    public void delete(int index) {
        if (index >= 0 && index < size) {
            System.out.println("Removed " + numbers[index] + " from index " + index);
            for (int i = index; i < size - 1; i++) {
                numbers[i] = numbers[i + 1]; // Shift elements to the left
            }
            size--; // Decrease the size
            numbers[size] = 0; // Optional: clear the last element
        } else {
            System.out.println("Invalid index: " + index);
        }
    }

    // Method to resize the array
    private void resize(int newCapacity) {
        numbers = Arrays.copyOf(numbers, newCapacity);
    }

    public static void main(String[] args) {
        SelectionSort sortArray = new SelectionSort(5);

        // Insert elements into the array
        sortArray.insert(64);
        sortArray.insert(25);
        sortArray.insert(12);
        sortArray.insert(22);
        sortArray.insert(11);

        System.out.println("Original Array:");
        sortArray.printArray();

        // Delete an element at index 2
        sortArray.delete(2);
        System.out.println("After Deletion:");
        sortArray.printArray();

        // Insert a new element
        sortArray.insert(30);
        System.out.println("After Insertion:");
        sortArray.printArray();

        // Sorting the array using selection sort
        sortArray.selectionSort();
        System.out.println("Sorted Array:");
        sortArray.printArray();
    }
}
