import java.util.*;

public class Q18_1 {
	static int Special_Add(int a, int b) {
		if (b == 0) {
			return a;
		}

		int sum = a ^ b;
		int carry = (a & b) << 1;
		return Special_Add(sum, carry);
	}

	public static void main(String[] args) {
		System.out.println(Special_Add(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
}