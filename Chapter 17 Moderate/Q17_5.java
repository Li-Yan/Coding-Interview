import java.util.*;

public class Q17_5 {
	static int Min(int a, int b) {
		return a < b ? a : b;
	}

	static boolean CodeCheck(String code) {
		if (code == null) {
			return false;
		}

		if (code.length() != 4) {
			return false;
		}

		for (int i = 0; i < 4; i++) {
			char c = code.charAt(i);
			if ((c != 'R') && (c != 'Y') && (c != 'G') && (c != 'B')) {
				return false;
			}
		}

		return true;
	}

	static void InitMap(HashMap<Character, Integer> Map) {
		Map.put('R', 0);
		Map.put('Y', 0);
		Map.put('G', 0);
		Map.put('B', 0);
	}

	static void SetCount(char C, HashMap<Character, Integer> Map) {
		int count = Map.get(C);
		Map.put(C, count + 1);
	}

	static String MasterMindCheck(String answer, String guess) {
		if (!CodeCheck(answer)) {
			return "Invalid answer!";
		}

		if (!CodeCheck(guess)) {
			return "Invalid guess!";
		}

		HashMap<Character, Integer> answerCharCountMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> guessCharCountMap = new HashMap<Character, Integer>();
		InitMap(answerCharCountMap);
		InitMap(guessCharCountMap);

		int hits = 0;
		int pseudo_hits = 0;

		for (int i = 0; i < 4; i++) {
			char cA = answer.charAt(i);
			char cG = guess.charAt(i);
			SetCount(cA, answerCharCountMap);
			SetCount(cG, guessCharCountMap);
			if (cA == cG) {
				hits++;
			}
		}

		Iterator iter = answerCharCountMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			char c = (Character) entry.getKey();
			pseudo_hits += Min(answerCharCountMap.get(c), guessCharCountMap.get(c));
		}
		pseudo_hits -= hits;

		return "Hits: " + hits + "; Pseudo-Hits: " + pseudo_hits;
	}

	public static void main(String[] args) {
		System.out.println(MasterMindCheck(args[0], args[1]));
	}
}