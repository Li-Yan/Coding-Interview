import java.util.*;

public class Q3_4 {
	static void MoveCurrent(int height, int local, int destination) {
		System.out.println("Move disk " +height + ": " + local + "->" + destination);
		return;
	}

	static void MoveUpAll(int height, int local, int assistant, int destination) {
		if (height < 1) {
			System.out.println("Wrong input!");
			return;
		}

		if (height == 1) {
			MoveCurrent(1, local, destination);
			return;
		}

		MoveUpAll(height - 1, local, destination, assistant);
		MoveCurrent(height, local, destination);
		MoveUpAll(height - 1, assistant, local, destination);
		return;
	}

	public static void main(String[] args) {
		MoveUpAll(Integer.parseInt(args[0]), 1, 2, 3);
	}
}