package com.jdsroom.sorting;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BubbleSort {

	private static Logger logger = LoggerFactory.getLogger(BubbleSort.class); 
	
	// sorting in increasing order using bubble sort where input is collection List
	public static List<Integer> bubbleSort(List<Integer> list) {

		int counter = list.size();
		int temp;
		while (counter > 0) {

			for (int i = 0; i < counter - 1; i++) {
				if (list.get(i) > list.get(i + 1)) {
					temp = list.get(i + 1);
					// list.add(i+1, list.get(i));
					list.set(i + 1, list.get(i));
					// list.add(i, temp);
					list.set(i, temp);
				}
			}
			counter--;
		}

		return list;
	}

	// sorting in increasing order using bubble sort where input is array
	public static Integer[] bubbleSortUsingArray(Integer[] array) {

		int counter = array.length;
		int temp;
		while (counter > 0) {

			for (int i = 0; i < counter - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
			}
			counter--;
		}

		return array;
	}

	// sorting in decreasing order using bubble sort where input is array
	public static Integer[] bubbleSortUsingArrayDecreasingOrder(Integer[] array) {

		int counter = array.length;
		int temp;
		while (counter > 0) {

			for (int i = 0; i < counter - 1; i++) {
				if (array[i] < array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
			}
			counter--;
		}

		return array;
	}

	// sorting in increasing order using recursion
	// Note- while calling this method pass size of array as counter
	public static Integer[] bubbleSortUsingRecursion(int counter, Integer[] array) {

		if (counter < 1) {
			return array;
		} else {
			int temp;
			for (int i = 0; i < counter - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
				}
			}
			return bubbleSortUsingRecursion(counter - 1, array);
		}
	}

	public void testcase() {

		logger.info("Unsorted List -->{}", Arrays.asList(10, 3, 4, 56, 78, 9, 2));
		logger.info("Bubble Sorted List -->{}", BubbleSort.bubbleSort(Arrays.asList(10, 3, 4, 56, 78, 9, 2)));

		logger.info("Unsorted List -->{}", Arrays.asList(10, 3, 4, -45, -124, 0, 0, 56, 78, 9, 2));
		logger.info("Bubble Sorted List -->{}",
				BubbleSort.bubbleSort(Arrays.asList(10, 3, 4, -45, -124, 0, 0, 56, 78, 9, 2)));

		logger.info("Unsorted List -->{}", Arrays.asList(10, 3, 4, 56, 567, 324, -455, 78, 9, 2, -765));
		logger.info("Bubble Sorted List -->{}",
				BubbleSort.bubbleSort(Arrays.asList(10, 3, 4, 56, 567, 324, -455, 78, 9, 2, -765)));

		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, 56, 78, 9, 2));
		Integer[] array = { 10, 3, 4, 56, 78, 9, 2 };
		array = BubbleSort.bubbleSortUsingArray(array);
		logger.info("Bubble Sorted Array -->{}", Arrays.toString(array));

		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, 56, 78, 9, 2));
		Integer[] reversearray = { 10, 3, 4, 56, 78, 9, 2 };
		reversearray = BubbleSort.bubbleSortUsingArrayDecreasingOrder(reversearray);
		logger.info("Bubble Sorted Array -->{}", Arrays.toString(reversearray));

		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, 56, 78, 9, 2));
		Integer[] recursion = { 10, 3, 4, 56, 78, 9, 2 };
		recursion = BubbleSort.bubbleSortUsingRecursion(recursion.length, recursion);
		logger.info("Bubble Sorted Array Through Recursion -->{}", Arrays.toString(recursion));

	}
}
