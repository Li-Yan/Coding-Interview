import java.util.*;

public class Q18_9 {
	static Random rdm = new Random(System.currentTimeMillis());
	
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
	
	public static void main(String[] args) {
		int[] array = GenerateArray(10);
		PrintArray(array);
		QuickMedian quickMedian = new QuickMedian();
		for (int i = 0; i < array.length; i++) {
			quickMedian.Insert(array[i]);
			System.out.println(quickMedian.GetMedian());
		}
		
	}
}
