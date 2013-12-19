package czt.learn.LeetCode;

import czt.learn.LeetCode.resources.ListNode;

public class LinkedListCycle {
	
	/**
	 * TestCase 1:
	 *  0 -> 1  ->  2
	 *       ^      |
	 *       |      |
	 *       -- 3 <--
	 * 
	 * @return
	 */
	public static ListNode createTestCase1() {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		
		return node0;
	}
	
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
