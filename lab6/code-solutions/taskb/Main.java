package taskb;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] testArr1 = {1,3,5,7,9,35}; 
		System.out.println("PrintHelloWorld Test1 [1,3,5,7,9,35]:");
		printHelloWorld(testArr1);
		
		int[] testArr2 = {7,35,48,55}; 
		System.out.println("\nPrintHelloWorld Test2 [7,35,48,55]:");
		printHelloWorld(testArr2);
		
		int[] testArr3 = {1,2,3,4,5}; 
		System.out.println("\nFindSecondBiggest Test1 [1,3,5,7,9,35]:");
		System.out.println("Result: " + findSecondBiggest(testArr3));
		
		int[] testArr4 = {19,9,11,0,12}; 
		System.out.println("\nFindSecondBiggest Test2 [7,35,48,55]:");
		System.out.println("Result: " + findSecondBiggest(testArr4));
	}
	
	public static void printHelloWorld(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%5==0 && arr[i]%7==0) System.out.println("HelloWorld");
			else if(arr[i]%5==0) System.out.println("Hello");
			else if(arr[i]%7==0) System.out.println("World");
		}
	}
	
	public static int findSecondBiggest(int[] arr) {
		int secondMax = arr[0];
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
 
			} else if (arr[i] > secondMax) {
				secondMax = arr[i];
 
			}
		}
		return secondMax;
	}
}
