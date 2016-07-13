package java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author Marcus
 *
 */
public class MergekSortedLists {
	public class ListNodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode x, ListNode y) {
			if (x.val < y.val) {
				return -1;
			} else if (x.val > y.val) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * k=number of lists, n=element in each list
	 * 
	 * Add to heap will cost Log(size of heap) = Log(k) total number of elements
	 * are k*n so The runtime should be O(Logk(kn))
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null;
		if (lists == null || lists.length == 0)
			return head;
		Queue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				minHeap.add(lists[i]);
			}
		}

		ListNode cur = new ListNode(0); // dummy head node for the result linked
										// list
		head = cur;

		while (!minHeap.isEmpty()) {
			ListNode temp = minHeap.poll();
			cur.next = temp; // update the result list
			cur = cur.next;
			temp = temp.next; // keep temp to the same list next element
			cur.next = null; // updat the result list's last element to set to
								// null
			if (temp != null) {
				minHeap.add(temp);
			}
		}
		return head.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
