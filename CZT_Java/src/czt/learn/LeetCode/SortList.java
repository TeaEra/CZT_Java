package czt.learn.LeetCode;

import czt.learn.LeetCode.resources.ListNode;

public class SortList {

    public static ListNode sortList(ListNode head) {
        
    	ListNode fakeHead = new ListNode(-1);
    	fakeHead.next = head;
    	
    	// ???
    	return null;
    }
    
    public static ListNode insertionList(ListNode head) {
    	// The scenario: empty list;
    	if (head == null) {
    		return head;
    	}
    	
    	ListNode preResHead = new ListNode(-1);
    	preResHead.next = head;
    	// If head is null, actually head.next will give out error;
    	// Hence, the empty list checking is necessary at the beginning;
    	ListNode currNode = head.next;
    	preResHead.next.next = null;
    	
    	while (currNode != null) {
    		int currVal = currNode.val;
    		
    		ListNode preCurrResNode = preResHead;
    		ListNode currResNode = preResHead.next;
    		while (currResNode != null && currResNode.val < currVal) {
    			currResNode = currResNode.next;
    			preCurrResNode = preCurrResNode.next;
    		}
    		
    		ListNode tempNode = currNode.next;
    		preCurrResNode.next = currNode;
    		currNode.next = currResNode;
    		currNode = tempNode;
    	}
    	
    	return preResHead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = ListNode.createListNode(new int[]{4, 5, 7, 0, 8, 2, 3, 9, 1, 6}).next;
		
		ListNode sortHead = SortList.insertionList(head);
		ListNode.showListNode(sortHead);
	}

}
