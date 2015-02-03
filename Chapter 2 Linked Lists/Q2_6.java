import java.util.*;

public class Q2_6 {

    static class Result {
        public LinkNode node;
        public boolean isPalindrome;

        public Result(LinkNode n, boolean b) {
            node = n;
            isPalindrome = b;
        }
    }

    static class LinkNode {
        public char value;
        public LinkNode next;

        public LinkNode(char v, LinkNode n) {
            value = v;
            next = n;
        }

        public int length() {
            int length = 1;
            LinkNode n = this;
            while (n.next != null) {
                length++;
                n = n.next;
            }
            return length;
        }
    }

    /**
     * @return the next node of the sublist and whether the sublist is a palindrome
     */
    public static Result verifyPalindrome(LinkNode n, int length) {
        if ((n == null) || (length < 0)) {
            return new Result(null, false);
        }

        if (length == 0) {
            return new Result(n, true);
        }

        if (length == 1) {
            return new Result(n.next, true);
        }

        Result r = verifyPalindrome(n.next, length - 2);

        if (r.node == null) {
            return new Result(null, false);
        }

        return new Result(r.node.next, r.isPalindrome ? n.value == r.node.value : false);
    }

    public static void main(String[] args) {
        LinkNode head = null;
        head = new LinkNode('a', null);
        head = new LinkNode('b', head);
        head = new LinkNode('c', head);
        head = new LinkNode('b', head);
        head = new LinkNode('a', head);

        System.out.println(head.length());
        System.out.println(verifyPalindrome(head, head.length()).isPalindrome);
    }
}