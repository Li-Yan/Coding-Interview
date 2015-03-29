import java.util.*;

public class Q2_2 {

    static class LinkNode {
        int value;
        LinkNode next;

        public LinkNode(int v, LinkNode n) {
            value = v;
            next = n;
        }
    }

    static class Result {
        int count;
        LinkNode node;

        public Result(int c, LinkNode r) {
            count = c;
            node = r;
        }
    }

    public static Result findKthNode(LinkNode current, int k) {
        if (current == null) {
            return new Result(0, null);
        }

        Result result = findKthNode(current.next, k);
        LinkNode node = result.node;
        int i = result.count + 1;
        if (i == k) {
            node = current;
        }

        return new Result(i, node);
    }

    public static void main(String[] args) {
        LinkNode head = null;
        head = new LinkNode(5, null);
        head = new LinkNode(4, head);
        head = new LinkNode(3, head);
        head = new LinkNode(2, head);
        head = new LinkNode(1, head);

        LinkNode node = findKthNode(head, 6).node;
        if (node != null) {
            System.out.println(node.value);
        }
    }
}