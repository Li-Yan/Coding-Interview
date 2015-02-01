import java.util.*;

public class SuffixNode {
	HashMap<Character, SuffixNode> childrens;
	ArrayList<Integer> indexes;

	public SuffixNode() {
		childrens = new HashMap<Character, SuffixNode>();
		indexes = new ArrayList<Integer>();
	}

	public void Insert(String s, int index) {
		indexes.add(index);
		if ((s == null) || (s.length() == 0)) {
			return;
		}
		char ch = s.charAt(0);
		SuffixNode child = childrens.get(ch);
		if (child == null) {
			child = new SuffixNode();
			childrens.put(ch, child);
		}
		if (s.length() > 1) {
			child.Insert(s.substring(1), index);
		}
		else {
			child.Insert(null, index);
		}
	}

	public ArrayList<Integer> Search(String s) {
		char ch = s.charAt(0);
		SuffixNode child = childrens.get(ch);
		if (child != null) {
			if (s.length() > 1) {
				return child.Search(s.substring(1));
			}
			else {
				return child.indexes;
			}
		}
		else {
			return null;
		}
	}
}