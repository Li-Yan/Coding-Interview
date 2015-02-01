import java.util.*;

public class Q17_4 {
	static int Maxof2(int a, int b) {
		/* Incorrect, Math.abs might use compare */
		return (a + b + Math.abs(a - b)) / 2;
	}

	static int bitFlip(int B) {
		return 0x1 ^ B;
	}

	static int getSign(int n) {
		return (n >> 31) & 0x1;
	}

	static int Maxof2_Demo(int a, int b) {
		int signOfA = getSign(a);
		int signOfB = getSign(b);
		int sign = getSign(a - b);

		int signDiffAB = signOfA ^ signOfB; // a and b same sign: 0; otherwise 1
		int kA_flipped = signOfA * signDiffAB + sign * bitFlip(sign); 

		return a * bitFlip(kA_flipped) + b * kA_flipped;
	}

	public static void main(String[] args) {
		System.out.println(Maxof2_Demo(10, 100));
		System.out.println(Maxof2_Demo(10, -100));
		System.out.println(Maxof2_Demo(-10, -100));
		System.out.println(Maxof2_Demo(Integer.MAX_VALUE - 2, -100));
	}
}