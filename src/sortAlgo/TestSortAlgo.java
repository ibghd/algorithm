package sortAlgo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class TestSortAlgo {

	public static int[] randomArray(int numberData) {
		int data[] = new int[numberData];
		Random rnd = new Random();
		for (int i = 0; i < numberData; i++) {
			data[i] = rnd.nextInt();
		}
		return data;
	}

	int data[] = randomArray(10000);
	int[] expected = Arrays.copyOf(data, data.length);

	@Test
	public void testSwap() {
		int[] actual = { 1, 2 };
		SortAlgo.swap(actual, 0, 1);
		int expected[] = { 2, 1 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testBubbleSort() {
		Arrays.sort(expected);
		int actual[] = SortAlgo.bubleSort(data);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testInsertionSort() {
		Arrays.sort(expected);
		int actual[] = SortAlgo.insertionSort(data);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testSelectionSort() {
		Arrays.sort(expected);
		int actual[] = SortAlgo.selectionSort(data);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testMergeSort() {
		Arrays.sort(expected);
		int actual[] = SortAlgo.mergeSortTopDown(data);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testQuickSort() {
		Arrays.sort(expected);
		int actual[] = SortAlgo.quicksort(data, 0, data.length - 1);
		assertArrayEquals(expected, actual);
	}

}
