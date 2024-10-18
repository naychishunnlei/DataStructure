package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] numbers = new int[10];
		
		for(int i = 0; i< numbers.length; i++) {
			numbers[i] = rand.nextInt(100);
		}
		
		System.out.println("Before: ");
		printArray(numbers);
		
		System.out.print("");
		System.out.print("Afer: ");
		insertionSort(numbers);
		printArray(numbers);
		
	}
	
	public static void insertionSort(int[] numbers) {
		for(int i=1; i< numbers.length; i++) {
			int current = numbers[i];
			
			int j = i - 1;
			
			while(j>=0 && numbers[j] > current) {
				numbers[j+1] = numbers[j];
				j--;
			}
			numbers[j+1] = current;		}
	}
	
	public static void printArray(int[] numbers) {
		for(int i =0; i< numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println("");
	}

}
