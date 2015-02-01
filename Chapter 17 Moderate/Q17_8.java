import java.util.*;

public class Q17_8 {
	static int[] GenerateArray(int size) {
		final int range = 1000;
		int[] array = new int[size];
		Random rdm = new Random(System.currentTimeMillis());

		for (int i = 0; i < size; i++) {
			array[i] = rdm.nextInt(range) - range / 2;
		}
		return array;
	}

	static int Max_Contiguous_Sequence(int[] array) {
		int max = 0;
		int maxWithEnd = 0;

		for (int i = 0; i < array.length; i++) {
			int m = maxWithEnd + array[i];
			if (m > max) {
				max = m;
			}
			if (m < 0) {
				maxWithEnd = 0;
			}
			else {
				maxWithEnd = m;
			}
		}
		return max;
	}

	static int Max_Contiguous_Sequence_Demo(int[] array) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (maxsum < sum) {
				maxsum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}

	public static void main(String[] args) {
		int[] array = GenerateArray(100);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println(Max_Contiguous_Sequence(array));
		System.out.println(Max_Contiguous_Sequence_Demo(array));
	}
}