import java.util.*;

public class Q18_3 {
	static int Count2s(int n) {
		int count = 0;
		int length = (int) Math.floor(Math.log10(n)) + 1;
		for (int i = 0; i < length; i++) {
			count += Count2sSub(n, i);
		}
		return count;
	}

	static int Count2sSub(int n, int index) {
		int currentPower = (int) Math.pow(10, index);
		int upperPower = currentPower * 10;
		int currentDigit = n / currentPower % 10;
		int upperDigit = n / upperPower;

		if (currentDigit < 2) {
			return upperDigit * currentPower;
		}
		else if (currentDigit == 2) {
			return upperDigit * currentPower + n % currentPower + 1;
		}
		else {
			return (upperDigit + 1) * currentPower;
		}
	}

	static int count2sInRangeAtDigit(int number, int d) {
		int powerOf10 = (int) Math.pow(10, d);
		int nextPowerOf10 = powerOf10 * 10;
		int right = number % powerOf10;

		int roundDown = number - number % nextPowerOf10;
		int roundUp = roundDown + nextPowerOf10;

		int digit = (number / powerOf10) % 10;
		if (digit < 2) {
			return roundDown / 10;
		}
		else if (digit == 2) {
			return roundDown / 10 + right + 1;
		}
		else {
			return roundUp / 10;
		}
	}

	static int Count2s_Demo(int number) {
		int count = 0;
		int len = String.valueOf(number).length();
		for (int digit = 0; digit < len; digit++) {
			count += count2sInRangeAtDigit(number, digit);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Count2s(Integer.parseInt(args[0])));
		System.out.println(Count2s_Demo(Integer.parseInt(args[0])));
	}
}