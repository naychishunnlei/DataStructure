

public class InsertSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0; i< numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before Insert Sorting: ");
        printArray(numbers);

        insertionSort(numbers);

        System.out.println("After InsertSorting: ");
        printArray(numbers);

        selectionSort(numbers);
        System.out.println("After SelectionSorting: ");
        System.out.println(numbers.toString(numbers));
    }

    public static void printArray(int[] numbers) {
        for(int i=0; i< numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }


    private static void insertionSort(int[] inputArray) {
        for(int i = 1; i< inputArray.length; i++) {
            int currentValue = inputArray[i];

            int j = i -1;

            while (j>=0 && inputArray[j] > currentValue) {
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = currentValue;
        }
        
    }

    private static void selectionSort(int[] inputArray) {
        int length = inputArray.length;
        for(int i =0; i< length - 1; i++){
            int min = inputArray[i];
            int indexofMin = i;
            for (int j = i+1; j< length; j++) {
                if(inputArray[j] < min) {
                    min = inputArray[j];
                    indexofMin = j;
                }
            }
        swap(inputArray, i, indexofMin);

        }
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
