import java.util.*;

public class Q1_5 {
	static String StringCompress(String originalString) {
		StringBuffer newString = new StringBuffer();
		Character lastChar = null;
		int count = 0;

		// Start checking String character by character
		for (int i = 0; i < originalString.length(); i++) {
			if (lastChar == null) {
				// First character
				lastChar = originalString.charAt(i);
				newString.append(lastChar);
				count = 1;
			}
			else if (lastChar == originalString.charAt(i)) {
				// The same as the previous character
				count++;
			}
			else {
				// Start a new character
				newString.append(count);
				count = 1;
				lastChar = originalString.charAt(i);
				newString.append(lastChar);
			}
		}
		newString.append(count);

		return newString.length() < originalString.length() ? newString.toString() : originalString;
	}

	public static void main(String[] args) {
		System.out.println(StringCompress(args[0]));
	}
}