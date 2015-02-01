import java.util.*;

public class QuickMedian {
	Comparator<Integer> minHeapComparator;
	Comparator<Integer> maxHeapComparator;
	public PriorityQueue<Integer> minHeap;
	public PriorityQueue<Integer> maxHeap;
	
	public QuickMedian() {
		minHeapComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		maxHeapComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -1 * o1.compareTo(o2);
			}
		};
		minHeap = new PriorityQueue<Integer>(1000, minHeapComparator);
		maxHeap = new PriorityQueue<Integer>(1000, maxHeapComparator);
	}
	
	public boolean Insert(int n) {
		if (minHeap.size() == 0) {
			minHeap.add(n);
			return true;
		}
		if (minHeap.peek() <= n) {
			minHeap.add(n);
		}
		else {
			maxHeap.add(n);
		}
		if (minHeap.size() > maxHeap.size() + 1) {
			maxHeap.add(minHeap.poll());
		}
		else if (minHeap.size() < maxHeap.size()) {
			minHeap.add(maxHeap.poll());
		}
		return true;
	}
	
	public double GetMedian() {
		if (minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		}
		else {
			return ((double) minHeap.peek() + maxHeap.peek()) / 2;
		}
	}
}