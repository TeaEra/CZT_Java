package czt.learn.LeetCode;

import czt.learn.LeetCode.resources.ListNode;

public class SortList {

    public static ListNode sortList(ListNode head) {
        
    	ListNode fakeHead = new ListNode(-1);
    	fakeHead.next = head;
    	
    	// ???
    	return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l = ListNode.createListNode(new int[]{4, 5, 7, 0, 8, 2, 3, 9, 1, 6}).next;
		SortList.sortList(l);
	}

}