package main;
import sortingTemplates.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] input = {5,2,4,6,1,3};
		Sort insertionSort = new InsertionSort();
		insertionSort.sort(input);
		for(Integer integer : input){
			System.out.print(integer + ", ");
		}
		System.out.println();
		
		Integer[] input1 = {2, 4, 5, 7, 1, 2, 3, 6};
		Sort mergeSort = new MergeSort();
		mergeSort.sort(input1);		
		for(Integer integer : input1){
			System.out.print(integer + ", ");
		}
		System.out.println();
		
		Integer[] input2 = {4,1,3,2,16,9,10,14,8,7};
		Sort heapSort = new HeapSort();
		heapSort.sort(input2);		
		for(Integer integer : input2){
			System.out.print(integer + ", ");
		}
		System.out.println();
		
		Integer[] input3 = {2, 8, 7, 1, 3, 5, 6, 4};
		Sort quickSort = new QuickSort();
		quickSort.sort(input3);		
		for(Integer integer : input3){
			System.out.print(integer + ", ");
		}
		System.out.println();
		
		Integer[] input4 = {2, 8, 7, 1, 3, 5, 6, 4};
		Sort selectionSort = new SelectionSort();
		selectionSort.sort(input4);		
		for(Integer integer : input4){
			System.out.print(integer + ", ");
		}
		System.out.println();
		
	}

}
