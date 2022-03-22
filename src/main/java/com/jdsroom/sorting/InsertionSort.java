package com.jdsroom.sorting;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertionSort {

	private static Logger logger = LoggerFactory.getLogger(InsertionSort.class);

	public static List<Integer> insertionSortIncreasingOrderUsingList(List<Integer> list) {

		int currentPosition = 0;
		while (currentPosition < list.size()) {

			int temp;
			for (int i = currentPosition; i > 0; i--) {
				if (list.get(i) < list.get(i - 1)) {
					temp = list.get(i - 1);
					list.set(i - 1, list.get(i));
					list.set(i, temp);
				} else {
					break;
				}
			}
			currentPosition++;
		}
		return list;
	}

	public static Integer[] insertionSortIncreasingOrderUsingArray(Integer[] array) {

		int currentPosition = 0;
		while (currentPosition < array.length) {

			int temp;
			for (int i = currentPosition; i > 0; i--) {
				if (array[i] < array[i - 1]) {
					temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
				} else {
					break;
				}
			}
			currentPosition++;
		}
		return array;
	}
}
