import java.util.*;

public class Q18_2 {
		static void Swap(int[] array, int index1, int index2) {
			int temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
			return;
		}

		static void CardShuffle(int[] cards) {
			Random rdm = new Random(System.currentTimeMillis());
			int l = cards.length;

			for (int i = 0; i < l; i++) {
				Swap(cards, i, rdm.nextInt(l - i) + i);
			}
		}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[] cards = new int[size];
		for (int i = 0; i < size; i++) {
			cards[i] = i;
		}
		
		CardShuffle(cards);

		for(int i = 0; i < size; i++) {
			System.out.print(cards[i] + " ");
		}
		System.out.println();
	}
}