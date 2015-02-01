import java.util.*;

public class Q18_6 {
	static Random rdm = new Random(System.currentTimeMillis());

	static void Swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		return;
	}

	static int[] GenerateArray(int size) {
		final int range = 1000;
		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			array[i] = rdm.nextInt(range);
		}
		return array;
	}

	static void PrintArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	static int NthSmallestHelp(int[] array, int start, int end, int N) {
		if (start >= end) {
			return array[start];
		}
		int m = start;
		Swap(array, end, rdm.nextInt(end - start) + start);
		for (int i = start; i < end; i++) {
			if (array[i] < array[end]) {
				Swap(array, m, i);
				m++;
			}
		}
		Swap(array, m, end);
		if (N < m + 1) {
			return NthSmallestHelp(array, start, m - 1, N);
		}
		else if (N == m + 1) {
			return array[m];
		}
		else {
			return NthSmallestHelp(array, m + 1, end, N);
		}
	}

	static int NthSmallest(int[] array, int N) {
		if ((N < 1) || (N > array.length)) {
			return Integer.MAX_VALUE;
		}
		return NthSmallestHelp(array, 0, array.length - 1, N);
	}

	public static void main(String[] args) {
		int[] array = GenerateArray(Integer.parseInt(args[0]));
		//PrintArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(NthSmallest(array, i + 1) + " ");
		}
		System.out.println();
	}
}