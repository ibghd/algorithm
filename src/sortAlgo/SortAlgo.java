package sortAlgo;

import java.util.Arrays;

public class SortAlgo {

	public static void swap(int[] t, int i, int j) {
		if (i >= t.length || j >= t.length || i < 0 || j < 0) {
			throw new Error("i or j: out of bound");
		}
		int tmp = t[i];
		t[i] = t[j];
		t[j] = tmp;
	}

	/**
	 * C = 0(n²)
	 */
	public static int[] bubleSort(int[] t) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < t.length - 1; i++) {
				if (t[i] > t[i + 1]) {
					sorted = false;
					swap(t, i, i + 1);
				}
			}
		}
		return t;
	}

	/**
	 * C = 0(n²)
	 */
	public static int[] insertionSort(int[] t) {
		for (int i = 1; i < t.length; i++) {
			int j = i;
			while (j - 1 >= 0 && t[j - 1] > t[j]) {
				swap(t, j - 1, j);
				j--;
			}
		}
		return t;
	}

	/*
	 * 0(n²)
	 */
	public static int[] selectionSort(int[] t) {
		for (int i = 0; i < t.length; i++) {
			int min = t[i];
			int index = i;
			for (int j = i + 1; j < t.length; j++) {
				if (t[j] < min) {
					min = t[j];
					index = j;
				}
			}
			swap(t, i, index);
		}
		return t;
	}

	/*
	 * Merge Sort C = 0( nlog(n) )
	 */
	public static int[] mergeSortTopDown(int[] a) {
		int b[] = Arrays.copyOf(a, a.length);
		split(a, 0, a.length, b);
		return b;
	}

	public static void split(int[] a, int begin, int end, int[] b) {
		if (end - begin < 2) {
			return;
		}
		int middle = (end + begin) / 2;
		split(b, begin, middle, a);
		split(b, middle, end, a);
		merge(a, begin, middle, end, b);
	}

	public static void merge(int[] a, int begin, int middle, int end, int[] b) {
		int i = begin;
		int j = middle;
		for (int k = begin; k < end; k++) {
			if (i < middle && (j >= end || a[i] < a[j])) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
		}
	}

	/**
	 * Quicksort 0(nlog(n)) average / O(n²) worst
	 */

	public static int[] quicksort(int[] a, int low, int high) {
		if ((high - low) > 0) {
			int pivot = partition(a, low, high);
			quicksort(a, low, pivot - 1);
			quicksort(a, pivot + 1, high);
		}
		return a;
	}

	private static int partition(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (a[j] < pivot) {
				i++;
				swap(a, i, j);
			}
		}
		if (a[i + 1] > pivot) {
			swap(a, i + 1, high);
		}
		return i + 1;
	}

}
