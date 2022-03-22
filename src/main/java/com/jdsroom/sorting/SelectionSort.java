package com.jdsroom.sorting;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectionSort {

	private static Logger logger = LoggerFactory.getLogger(SelectionSort.class); 
	
	public static List<Integer> selectionSortIncreasingOrder(List<Integer> list) {

		int currentPosition = 0;
		while (currentPosition < list.size()) {

			int temp = list.get(currentPosition);
			int position = currentPosition;
			for (int i = currentPosition; i < list.size() - 1; i++) {
				if (temp > list.get(i + 1)) {
					temp = list.get(i + 1);
					position = i + 1;
				}
			}
			list.set(position, list.get(currentPosition));
			list.set(currentPosition, temp);
			currentPosition++;
		}
		return list;
	}

	public static Integer[] selectionSortIncreasingOrderUsingArray(Integer[] array) {

		int currentPosition = 0;
		while (currentPosition < array.length) {

			int temp = array[currentPosition];
			int position = currentPosition;
			for (int i = currentPosition; i < array.length - 1; i++) {
				if (temp >array[i + 1]) {
					temp = array[i + 1];
					position = i + 1;
				}
			}
			array[position] = array[currentPosition];
			array[currentPosition] = temp;
			currentPosition++;
		}
		return array;
	}
	
	public static void testCaseForSelectionSort() {
		logger.info("Unsorted List -->{}", Arrays.asList(10, 3, 4, 56, 78, 9, 2));
		logger.info("Selection Sorted List -->{}", SelectionSort.selectionSortIncreasingOrder(Arrays.asList(10, 3, 4, 56, 78, 9, 2)));

		logger.info("Unsorted List -->{}", Arrays.asList(10, 3, 4, -45, -124, 0, 0, 56, 78, 9, 2));
		logger.info("Selection Sorted List -->{}",
				SelectionSort.selectionSortIncreasingOrder(Arrays.asList(10, 3, 4, -45, -124, 0, 0, 56, 78, 9, 2)));

		logger.info("Unsorted List -->{}", Arrays.asList(10, 3, 4, 56, 567, 324, -455, 78, 9, 2, -765));
		logger.info("Selection Sorted List -->{}",
				SelectionSort.selectionSortIncreasingOrder(Arrays.asList(10, 3, 4, 56, 567, 324, -455, 78, 9, 2, -765)));
		
		logger.info("Selection Sorted Array::::::::::::::::::::::::");
		
		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, 56, 78, 9, 2));
		Integer[] array = { 10, 3, 4, 56, 78, 9, 2 };
		array = SelectionSort.selectionSortIncreasingOrderUsingArray(array);
		logger.info("Selection Sorted Array -->{}", Arrays.toString(array));

		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, -45, -124, 0, 0, 56, 78, 9, 2));
		Integer[] reversearray = { 10, 3, 4, -45, -124, 0, 0, 56, 78, 9, 2 };
		reversearray = SelectionSort.selectionSortIncreasingOrderUsingArray(reversearray);
		logger.info("Selection Sorted Array -->{}", Arrays.toString(reversearray));

		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, 56, 567, 324, -455, 78, 9, 2, -765));
		Integer[] recursion = { 10, 3, 4, 56, 567, 324, -455, 78, 9, 2, -765 };
		recursion = SelectionSort.selectionSortIncreasingOrderUsingArray(recursion);
		logger.info("Selection Sorted Array Through Recursion -->{}", Arrays.toString(recursion));
	}
}
