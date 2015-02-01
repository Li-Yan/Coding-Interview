import java.util.ArrayList;

public class Q17_3 {
	static int Trailing_Zeros(int N) {
		if (N < 0) {
			return -1;
		}
		
		int zerosNum = 0;
		ArrayList<Integer> fivesList = new ArrayList<Integer>();
		int fives = 5;
		
		while (N >= fives) {
			fivesList.add(0, N / fives);
			fives *= 5;
		}
		
		int length = fivesList.size();
		for (int i = 0; i < fivesList.size(); i++) {
			if (i == 0) {
				zerosNum += fivesList.get(i) * length;
			}
			else {
				zerosNum += (fivesList.get(i) - fivesList.get(i -1)) * length;
			}
			length--;
		}
		
		return zerosNum;
	}
	
	static int Trailing_Zeros_Demo(int N) {
		int count = 0;
		if (N < 0) {
			return -1;
		}
		
		for (int i = 5; N / i > 0; i *= 5) {
			count += N / i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(Trailing_Zeros(5) + " " +Trailing_Zeros_Demo(5));
		System.out.println(Trailing_Zeros(25) + " " +Trailing_Zeros_Demo(25));
		System.out.println(Trailing_Zeros(125) + " " +Trailing_Zeros_Demo(125));
	}
}
