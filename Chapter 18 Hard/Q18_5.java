import java.util.*;
import java.io.*;

public class Q18_5 {
	static ArrayList<String> ReadDocument() {
		ArrayList<String> arrayList = new ArrayList<String>();
		BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
		String s = null;

		while (true) {
			try {
				s = input.readLine();
			}
			catch (Exception e) {}
			if (s.equals("###")) {
				break;
			}
			else {
				arrayList.add(s.toLowerCase());
			}
		}

		return arrayList;
	}

	static int ShortestWordsDistance(ArrayList<String> arrayList, String word1, String word2) {
		int index1 = -1;
		int index2 = -1;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arrayList.size(); i++) {
			if (word1.equals(arrayList.get(i))) {
				index1 = i;
				if ((index2 > -1) && (index1 - index2 < min)) {
					min = index1 - index2;
				}
			}
			if (word2.equals(arrayList.get(i))) {
				index2 = i;
				if ((index1 > -1) && (index2 - index1 < min)) {
					min = index2 - index1;
				}
			}
		}

		if ((index1 == -1) || (index2 == -1)) {
			return -1;
		}

		return min;
	}

	public static void main(String[] args) {
		ArrayList<String> arrayList = ReadDocument();
		System.out.println(ShortestWordsDistance(arrayList, args[0], args[1]));
	}
}