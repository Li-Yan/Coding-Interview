import java.util.*;

public class Q9_6 {
    public static void allBracketsHelper(LinkedList<Character> list, int leftCount,
        int rightCount, int pairCount) {
        if ((leftCount > pairCount) || (rightCount > pairCount)) {
            // handle out of boundary exception
            return;
        }

        if (list.size() != leftCount + rightCount) {
            // handle invalid list
            return;
        }

        if ((leftCount == pairCount) && (rightCount == pairCount)) {
            System.out.println(list.toString());
            return;
        }

        if (leftCount < pairCount) {
            list.addLast('(');
            allBracketsHelper(list, leftCount + 1, rightCount, pairCount);
            list.removeLast();
        }

        if (leftCount > rightCount) {
            list.addLast(')');
            allBracketsHelper(list, leftCount, rightCount + 1, pairCount);
            list.removeLast();
        }

        return;
    }

    public static void allBrackets(int pairCount) {
        if (pairCount <= 0) {
            return;
        }

        allBracketsHelper(new LinkedList<Character>(), 0, 0, pairCount);
    }

    public static void main(String[] args) {
        System.out.println("- 1 -");
        allBrackets(1);
        System.out.println("- 2 -");
        allBrackets(2);
        System.out.println("- 3 -");
        allBrackets(3);
        System.out.println("- 4 -");
        allBrackets(4);
    }
}