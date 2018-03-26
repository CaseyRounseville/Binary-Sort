package main;

import java.util.Scanner;
import java.util.Arrays;

public class BinarySort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] tokens = input.split("\\s+");
		
		int[] arr = new int[tokens.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tokens[i]);
		}
		
		System.out.println("initial array: " + Arrays.toString(arr));
		binarySort(arr);
		System.out.println("sorted array: " + Arrays.toString(arr));
	}
	
	public static void binarySort(int[] arr) {
		System.out.println("beginning binary sort");
		for (int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int comp = arr[i - 1];
			move(arr, binarySearch(arr, target, 0, i - 1), i);
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("done with binary sort");
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		System.out.println("start: " + start + "\tend: " + end + "\ttarget: " + target);
		
		if (end < start) {
			return start;
		}
		
		int mid = (start + end) / 2;
		
		if (arr[mid] == target) {
			return mid;
		} else if (arr[mid] > target) {
			return binarySearch(arr, target, start, mid - 1);
		} else {
			return binarySearch(arr, target, mid + 1, end);
		}
	}
	
	/*
	assumes dest < src
	*/
	public static void move(int[] arr, int dest, int src) {
		int temp = arr[src];
		for (int i = src - 1; i > dest - 1; i--) {
			arr[i + 1] = arr[i];
		}
		arr[dest] = temp;
	}
}