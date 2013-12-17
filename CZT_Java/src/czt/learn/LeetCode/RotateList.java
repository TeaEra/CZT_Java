package czt.learn.LeetCode;

import czt.learn.LeetCode.resources.ListNode;

// Actually I add many kinds of permutation functions here;
public class RotateList {
	
    public static ListNode reverse(ListNode head) {
          	
    	ListNode preNode = null;
    	ListNode currNode = head;
    	ListNode resHead = null;
    	
    	while (currNode != null) {
    		ListNode tempNode = currNode.next;
    		currNode.next = preNode;
    		preNode = currNode;
    		resHead = currNode;
    		
    		if (tempNode != null) {
    			currNode = tempNode;
    		}
    		else {
    			break;
    		}
    	}
    	return resHead;
    }
    
    public static ListNode rightShift(ListNode head, int n) {
    	if (head == null) {
    		return head;
    	}
    	// The codes above could avoid the scenario: size == 0;
    	
    	int size = 0;
    	ListNode copyHead = head;
    	while (copyHead != null) {
    		size++;
    		copyHead = copyHead.next;
    	}
    	// Should consider the scenario: n >= size;
    	// Use '%';
    	n = n >= size ? n % size : n;
    	if (n == 0) {
    		return head;
    	}
    	// The number of nodes in left part;
    	int leftCount = size - n;
    	
    	ListNode leftFakeHead = new ListNode(-1);
    	leftFakeHead.next = null;
    	ListNode rightFakeHead = new ListNode(-1);
    	rightFakeHead.next = null;
    	
    	ListNode copyLeftFakeHead = leftFakeHead;
    	copyHead = head;
    	for (int i=0; i<leftCount; ++i) {
    		copyLeftFakeHead.next = copyHead;
    		copyLeftFakeHead = copyHead;
    		copyHead = copyHead.next;
    	}
    	rightFakeHead.next = copyLeftFakeHead.next;
    	copyLeftFakeHead.next = null;
    	//
    	ListNode copyRightFakeHead = rightFakeHead;
    	while (copyRightFakeHead.next != null) {
    		copyRightFakeHead = copyRightFakeHead.next;
    	}
    	copyRightFakeHead.next = leftFakeHead.next;
    	return rightFakeHead.next;
    }
    
    // ???
    public static ListNode leftShift(ListNode head, int ls) {
    	return null;
    }
    
    public static ListNode swapPairs(ListNode head) {
    	
    	if (head == null) {
    		return head;
    	}
    	
    	ListNode copyHead = head;
    	// The fake head for result;
    	ListNode resHead = new ListNode(-1);
    	resHead.next = null;
    	ListNode copyResHead = resHead;
    	ListNode first = null;
    	ListNode second = null;
    	
    	while (copyHead != null) {
    		first = copyHead;
    		second = copyHead.next;
    		
    		if (second == null) {
    			copyResHead.next = first;
    			break;
    		}
    		else {
    			ListNode temp = second.next;
    			second.next = first;
    			first.next = temp;
    			copyHead = temp;
    			copyResHead.next = second;
    			copyResHead = copyResHead.next.next;
    		}
    	}
    	
        return resHead.next;
    }
    
    public static void reorderList(ListNode head) {
    	if (head == null) {
    		return;
    	}
    	
    	ListNode copyHead = head;
    	int size = 0;
    	while (copyHead != null) {
    		size++;
    		copyHead = copyHead.next;
    	}
    	
    	boolean isEven = true;
    	int half;
    	//
		ListNode leftHead = head;
		ListNode rightHead = null;
    	
    	if (size % 2 == 0) {
    		half = size/2;
    		isEven = true;
    	}
    	else {
    		half = (size+1)/2;
    		isEven = false;
    	}
		
		ListNode preNode = null;
		ListNode currNode = head;
		for (int i=0; i<half; ++i) {
			preNode = currNode;
			currNode = currNode.next;
		}
		preNode.next = null;
		rightHead = currNode;
		
		// Reverse the right part;
		preNode = null;
    	currNode = rightHead;
    	ListNode reverseRightHead = null;
    	//
    	while (currNode != null) {
    		ListNode tempNode = currNode.next;
    		currNode.next = preNode;
    		preNode = currNode;
    		reverseRightHead = currNode;
    		
    		if (tempNode != null) {
    			currNode = tempNode;
    		}
    		else {
    			break;
    		}
    	}
    	
    	//ListNode.showListNode(leftHead);
    	//ListNode.showListNode(reverseRightHead);
    	
    	ListNode currLeftNode = leftHead;
    	ListNode currRightNode = reverseRightHead;
    	while (currRightNode != null) {
    		ListNode tempLeftNode = currLeftNode.next;
    		currLeftNode.next = currRightNode;
    		ListNode tempRightNode = currRightNode.next;
    		currRightNode.next = tempLeftNode;
    		
    		currRightNode = tempRightNode;
    		currLeftNode = tempLeftNode;
    	}
    	
    	head = leftHead;
    	//ListNode.showListNode(head);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Reverse the whole list;
		/*ListNode head = ListNode.createListNode(new int[]{1}).next;
		ListNode.showListNode(head);
		ListNode rotateHead = RotateList.reverse(head);
		ListNode.showListNode(rotateHead);*/
		
		// Right shift;
		/*ListNode head = ListNode.createListNode(new int[]{1,2}).next;
		ListNode.showListNode(head);
		ListNode rsHead = RotateList.rightShift(head, 2);
		ListNode.showListNode(rsHead);*/
		
		// Swap pairs;
		/*ListNode head = ListNode.createListNode(new int[]{1,2,3,4,5}).next;
		ListNode.showListNode(head);
		ListNode swapHead = RotateList.swapPairs(head);
		ListNode.showListNode(swapHead);*/
		
		// Reorder list;
		ListNode head = ListNode.createListNode(new int[]{1,2,3,4,5}).next;
		ListNode.showListNode(head);
		RotateList.reorderList(head);
		//ListNode.showListNode(head);
	}

}
