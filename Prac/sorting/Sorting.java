package sorting;

public class Sorting {
    private int[] array;

    // Constructor to initialise the array
    public Sorting(int[] arr) {
        this.array = arr;
    }

    // Instance method to perform insertion sort
    public void insertSort() {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
    
    public void selectionSort(){
        int len = array.length;
        
        for(int i=0; i<len-1; i++){
            int minIndex = i;
            
            for(int j=i+1; j< len; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void quickSort(int[] arr, int lowIndex, int highIndex){
        if(lowIndex >= highIndex) {
            return;
        }
        int pivot = arr[highIndex];
        int leftPointer = partition(arr, lowIndex, highIndex, pivot);
        
        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }
    
    private static int partition(int[] arr, int lowIndex, int highIndex, int pivot){
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        
        while(leftPointer < rightPointer){
            while(arr[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(arr[rightPointer] > pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        return leftPointer;
    }
    
    public void mergeSort(int[] arr){
        int len = arr.length;
        
        if(len < 2){
            return;
        }
        
        int midIndex = len / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[len - midIndex];
        
        for(int i = 0; i < midIndex; i++){
            leftHalf[i] = arr[i];
        }
        
        for(int i = midIndex; i < len; i++){
            rightHalf[i - midIndex] = arr[i];
        }
        
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(arr, leftHalf, rightHalf);
    }
    
    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        
        int i = 0, j = 0, k = 0;
        
        while(i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                arr[k] = leftHalf[i];
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        
        while(i < leftSize){
            arr[k] = leftHalf[i];
            i++;
            k++;
        }
        while(j < rightSize){
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }
    
    public void countingSort(){
        int min = getMin(array);
        int max = getMax(array);
        
        int range=max - min +1;
        int[] countArray = new int[range];
        for(int num: array){
            countArray[num-min]++;
        }
        
        int arrayIndex=0;
        for(int i=0; i<range; i++){
            while(countArray[i]>0){
                array[arrayIndex]=i+min;
                countArray[i]--;
                arrayIndex++;
            }
        }
    }
    
    public void radixSort(){
        int max = getMax(array);
        
        //for every digit
        for(int exp=1; max/exp >0; exp *= 10){
            countingSortByDigit(exp);
        }
    }
    
    private void countingSortByDigit(int exp){
        int n = array.length;
        int[] outputArray = new int[n];
        int[] countArray = new int[10];
        
        for(int i=0; i<n; i++){
            int digit = (array[i]/exp)% 10;
            countArray[digit]++;
        }
        
        for(int i=1; i<10; i++){
            countArray[i] += countArray[i - 1];
        }
        
        for(int i=n-1; i >=0; i--){
            int digit = (array[i]/exp) % 10;
            outputArray[countArray[digit]- 1] = array[i];
            countArray[digit]--;
        }
        
        System.arraycopy(outputArray, 0, array, 0, n);
    }
    
    public void shellSort(){
        int n = array.length;
        
        for(int gap=n/2; gap>0; gap /= 2){
            for(int i=gap; i<n; i++){
                int temp = array[i];
                int j;
                
                for(j=i; j>= gap && array[j - gap] > temp; j -= gap){
                    array[j] = array[j- gap];
                }
                
                array[j] = temp;
            }
        }
    }
    
    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    private int getMin(int[] inputArr){
        int min = inputArr[0];
        for(int num: inputArr){
            if(num < min){
                min = num;
            }
        }
        return min;
    }
    
    // Method to print the array
    public void printArray() {
        for (int num : array) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Example for Insertion Sort
        int[] arr = {3, 1, 8, 6, 2};
        Sorting sortingArray = new Sorting(arr);
        System.out.print("Before Insertion Sort: ");
        sortingArray.printArray();
        sortingArray.insertSort();
        System.out.print("After Insertion Sort: ");
        sortingArray.printArray();
        
        // Example for Selection Sort
        int[] arr2 = {9, 10, 4, 3, 6};
        Sorting selectionSortingArray = new Sorting(arr2);
        System.out.print("Before Selection Sort: ");
        selectionSortingArray.printArray();
        selectionSortingArray.selectionSort();
        System.out.print("After Selection Sort: ");
        selectionSortingArray.printArray();
        
        // Example for Quick Sort
        int[] arr3 = {7, 2, 1, 6, 8, 5};
        Sorting quickSortArray = new Sorting(arr3);
        System.out.print("Before Quick Sort: ");
        quickSortArray.printArray();
        Sorting.quickSort(arr3, 0, arr3.length - 1);
        System.out.print("After Quick Sort: ");
        System.out.println(java.util.Arrays.toString(arr3));
        
        // Example for Merge Sort
        int[] arr4 = {5, 8, 2, 6, 0};
        Sorting mergeSortArray = new Sorting(arr4);
        System.out.print("Before Merge Sort: ");
        mergeSortArray.printArray();
        mergeSortArray.mergeSort(arr4);
        System.out.print("After Merge Sort: ");
        mergeSortArray.printArray();
        
        int[] arr5 = {4, -1, 2, 2, 8, 3, -3, 1};
        Sorting countingSortArray = new Sorting(arr5);
        System.out.print("Before Counting Sort: ");
        countingSortArray.printArray();
        countingSortArray.countingSort();
        System.out.print("After Counting Sort: ");
        countingSortArray.printArray();
        
        int[] arr6 = {170, 45, 75, 90, 802, 24, 2, 66};
        Sorting radixSortArray = new Sorting(arr6);
        System.out.print("Before Radix Sort: ");
        radixSortArray.printArray();
        radixSortArray.radixSort();
        System.out.print("After Radix Sort: ");
        radixSortArray.printArray();
        
        int[] arr7 = {12, 34, 54, 2, 3};
        Sorting shellSortArray = new Sorting(arr7);
        System.out.print("Before Shell Sort: ");
        shellSortArray.printArray();
        shellSortArray.shellSort();
        System.out.print("After Shell Sort: ");
        shellSortArray.printArray();

        
    }
}
