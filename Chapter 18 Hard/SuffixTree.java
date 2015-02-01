import java.util.*;

public class SuffixTree {
	SuffixNode root;

	public SuffixTree() {
		root = new SuffixNode();
	}

	public SuffixTree(String s) {
		root = new SuffixNode();
		for (int i = 0; i < s.length(); i++) {
			root.Insert(s.substring(i), i);
		}
	}

	public ArrayList<Integer> Search(String s) {
		return root.Search(s);
	}
}