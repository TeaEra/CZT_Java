package czt.learn.dzgz;

import java.util.Vector;

public class LoveSingleLinkedList {
	
	class Node {
		int value;
		Node nextNode;
		
		Node(int value) {
			this.value = value;
			this.nextNode = null;
		}
		
		Node(int value, Node next) {
			this.value = value;
			this.nextNode = next;
		}
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public Node createSLL(String str) {
		Vector<Node> nodes = new Vector<Node>();
		// Add the head
		nodes.add(new Node(-1));
		for (int i=str.length()-1; i>=0; --i) {
			nodes.add(new Node(Integer.valueOf(str.substring(i, i+1)).intValue()));
		}
		
		for (int i=0; i<nodes.size()-1; ++i) {
			nodes.get(i).nextNode = nodes.get(i+1);
		}
		
		return nodes.firstElement();
	}
	
	public Node plusSLL(String a, String b) {
		Node ahead = createSLL(a);
		Node bhead = createSLL(b);
		int carry = 0;
		StringBuffer sb = new StringBuffer();
		
		Node an = ahead;
		Node bn = bhead;
		while (an.nextNode != null && bn.nextNode != null) {
			Node acurr = an.nextNode;
			Node bcurr = bn.nextNode;
			int ia = acurr.value;
			int ib = bcurr.value;
			int sum = ia + ib + carry;
			int rem = sum % 10;
			carry = sum / 10;
			sb.append(String.valueOf(rem));
			an = an.nextNode;
			bn = bn.nextNode;
		}
		
		Node cn = null;
		if (an.nextNode != null) {
			cn = an;
		}
		if (bn.nextNode != null) {
			cn = bn;
		}
		if (cn != null) {
			while (cn.nextNode != null) {
				Node ccurr = cn.nextNode;
				int ic = ccurr.value;
				int sum = ic + carry;
				int rem = sum % 10;
				carry = sum / 10;
				sb.append(String.valueOf(rem));
				cn = cn.nextNode;
			}
		}
		// To avoid missing the remaining carry;
		if (carry != 0) {
			sb.append(String.valueOf(carry));
		}
		
		System.out.println(sb.reverse().toString());
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoveSingleLinkedList lsll = new LoveSingleLinkedList();
		String a = "1234";
		String b = "555";
		lsll.plusSLL(a, b);
		a = "999999";
		b = "1";
		lsll.plusSLL(a, b);
	}

}
