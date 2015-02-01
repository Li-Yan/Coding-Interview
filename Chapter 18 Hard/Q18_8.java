import java.util.*;

public class Q18_8 {

	public static void main(String[] args) {
		SuffixTree tree = new SuffixTree(args[0]);
		System.out.println(tree.Search(args[1]));
	}
}