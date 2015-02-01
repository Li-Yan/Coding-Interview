import java.util.*;

public class Heap {
	/* Min-Heap */
	static void Swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		return;
	}

	static int[] GenerateArray(int size) {
		final int range = 1000;
		int[] array = new int[size];
		Random rdm = new Random(System.currentTimeMillis());

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

	static void Heapify(int[] heap, int index, int bound) {
		if (index * 2 >= bound) {
			return;
		}
		int childMin = index * 2;
		if (index * 2 + 1 < bound) {
			childMin = heap[index * 2] < heap[index * 2 + 1] ? index * 2 : index * 2 + 1;
		}
		if (heap[index] > heap[childMin]) {
			Swap(heap, index, childMin);
			Heapify(heap, childMin, bound);
		}
	}

	static void HeapBuild(int[] heap) {
		for (int i = heap.length / 2; i >= 0; i--) {
			Heapify(heap, i, heap.length);
		}
	}

	static void HeapSort(int[] heap) {
		for (int i = heap.length - 1; i >= 0; i--) {
			Swap(heap, 0, i);
			Heapify(heap, 0, i);
		}
	}

	public static void main(String[] args) {
		int[] array = GenerateArray(Integer.parseInt(args[0]));
		PrintArray(array);
		HeapBuild(array);
		PrintArray(array);
		HeapSort(array);
		PrintArray(array);
	}
}