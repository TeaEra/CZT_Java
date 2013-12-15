package czt.learn.LeetCode.resources;

// Definition for singly-linked list.
public class ListNode {
	public int val;
    public ListNode next;
	
    public ListNode(int x) {
		val = x;
		next = null;
	}
    
    public static void showListNode(ListNode head) {
    	// Create the Node, whose next is the actual head Node;
    	// I called this fake head and used -1 as the default value;
    	ListNode temp = new ListNode(-1);
    	temp.next = head;
    	
    	System.out.print("{");
    	while (temp.next != null) {
    		temp = temp.next;
    		System.out.print(temp.val);
    		if (temp.next != null) {
    			System.out.print(" -> ");
    		}
    	}
    	System.out.print("}");
    	System.out.println();
    }
    
    public static ListNode createListNode(int[] arr) {
    	// The fake head;
    	ListNode head = new ListNode(-1);
    	head.next = null;
    	
    	// 
    	ListNode anoHead = head;
    	for (int i=0; i<arr.length; ++i) {
    		ListNode tempNode = new ListNode(arr[i]);
    		tempNode.next = null;
    		anoHead.next = tempNode;
    		anoHead = anoHead.next;
    	}
    	return head;
    }
    
    public static int getSize(ListNode head) {
    	// Without using fake head;
    	ListNode anoHead = head;
    	int size = 0;
    	while (anoHead != null) {
    		size++;
    		anoHead = anoHead.next;
    	}
    	return size;
    }
}
