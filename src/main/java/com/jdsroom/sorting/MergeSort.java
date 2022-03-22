package com.jdsroom.sorting;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class MergeSort {

	private static Logger logger = LoggerFactory.getLogger(MergeSort.class);

	public static Integer[] mergeSort(Integer[] array) {
		Integer[] result = new Integer[array.length];
		mergeSort(array, result, 0, array.length - 1);
		return array;
	}

	private static void mergeSort(Integer[] array, Integer[] temp, int start, int end) {
		if (start >= end) {
			return;
		}
		int midpoint = (start + end) / 2;
		mergeSort(array, temp, start, midpoint);
		mergeSort(array, temp, midpoint + 1, end);
		mergeHalves(array, temp, start, midpoint, end);
	}

	private static void mergeHalves(Integer[] array, Integer[] temp, int start, int middle, int end) {
		int leftStart = start;

		int leftEnd = middle;
		int rightStart = middle + 1;

		int rightEnd = end;
		int index = leftStart;
		while (leftStart <= leftEnd && rightStart <= rightEnd) {
			if (array[leftStart] <= array[rightStart]) {
				temp[index] = array[leftStart];
				leftStart++;
			} else {
				temp[index] = array[rightStart];
				rightStart++;
			}
			index++;
		}

		while (leftStart <= leftEnd) {
			temp[index] = array[leftStart];
			index++;
			leftStart++;
		}

		while (rightStart <= rightEnd) {
			temp[index] = array[rightStart];
			index++;
			rightStart++;
		}
		index = index - 1;
		while (index >= start) {
			array[index] = temp[index];
			index--;
		}
	}

	public void testCase() {

		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, 56, 78, 9, 2));
		Integer[] array = { 10, 3, 4, 56, 78, 9, 2 };
		array = MergeSort.mergeSort(array);
		logger.info("Merge Sorted Array -->{}", Arrays.toString(array));

		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, -45, -124, 0, 0, 56, 78, 9, 2));
		Integer[] array1 = { 10, 3, 4, -45, -124, 0, 0, 56, 78, 9, 2 };
		array1 = MergeSort.mergeSort(array1);
		logger.info("Merge Sorted Array -->{}", Arrays.toString(array1));

		logger.info("Unsorted Array -->{}", Arrays.asList(10, 3, 4, 56, 567, 324, -455, 78, 9, 2, -765));
		Integer[] array2 = { 10, 3, 4, 56, 567, 324, -455, 78, 9, 2, -765 };
		array2 = MergeSort.mergeSort(array2);
		logger.info("Merge Sorted Array -->{}", Arrays.toString(array2));
	}
	
	public void testCaseForLargeInputs() {
		StopWatch stopWatch = new StopWatch("mergeSort");
		//Arrays.asList(10,3,4,56,78,9,2);
		stopWatch.start("Merge");
		Random random = new Random();
		Integer[] number = new Integer[100000000];
		
		for(int i=0;i<number.length;i++) {
			number[i] = random.nextInt(1000000);
		}
//		logger.info("Un Sorted Array -->{}", Arrays.toString(number));
//		logger.info("Merge Sorted Array -->{}", Arrays.toString(MergeSort.mergeSort(number)));
		MergeSort.mergeSort(number);
		
		stopWatch.stop();
		logger.info("Merge Sort stopWatch -->{} seconds", stopWatch.getTotalTimeSeconds());
		
//		stopWatch.start("Merge print");
//		for(int i=0;i<number.length;i++) {
//			System.out.print(number[i]+" , ");
//		}
//		stopWatch.stop();
//		logger.info("Merge Sort print stopWatch -->{} seconds", stopWatch.getTotalTimeSeconds());
	}
}
