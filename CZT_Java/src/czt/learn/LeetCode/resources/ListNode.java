package czt.learn.LeetCode.resources;

import java.util.List;

// Definition for singly-linked list.
public class ListNode {
	public int val;
    public ListNode next;

	public ListNode() {
	    val = -1;
	    next = null;
	}

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

    // [LeetCode] Merge two sorted list;
    //
    // Step1: assume all in ascending;
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode tempRes = fakeHead;
        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;
        while (tempNode1 != null && tempNode2 != null) {
            if (tempNode1.val < tempNode2.val) {
                tempRes.next = tempNode1;
                tempNode1 = tempNode1.next;
            }
            else {
                tempRes.next = tempNode2;
                tempNode2 = tempNode2.next;
            }
            tempRes = tempRes.next;
        }

        if (tempNode1 != null) {
            tempRes.next = tempNode1;
        }
        if (tempNode2 != null) {
            tempRes.next = tempNode2;
        }

        return fakeHead.next;
    }

    // [LeetCode] Sort list;
    //
    // Ver 1: nlogn; insertion sort;
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // ???

        return null;
    }

    // Main
    public static void main(String[] args) {
        // Test: mergeTwoLists
        /*ListNode head1 = ListNode.createListNode(new int[]{1, 2, 3});
        ListNode head2 = ListNode.createListNode(new int[]{4, 5, 6});
        ListNode.showListNode(ListNode.mergeTwoLists(head1.next, head2.next));*/

        // Test:
        ListNode head = ListNode.createListNode(new int[]{3,1,4,6,5,2,0});
        ListNode.showListNode(ListNode.sortList(head.next));
    }
}
