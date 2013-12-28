package czt.learn.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
	
	//
    public static int evalRPN(String[] tokens) {
    	List<Integer> numList = new ArrayList<Integer>();
    	int numSize = 0;
        
        for (int i=0; i<tokens.length; ++i) {
        	int num1, num2;
        	if ("+".equals(tokens[i])) {
        		num1 = numList.get(numSize-1).intValue();
        		numSize--;
        		num2 = numList.get(numSize-1).intValue();
        		numSize--;
        		numList.set(numSize, num1+num2);
        		numSize++;
        	}
        	else if ("-".equals(tokens[i])) {
        		num1 = numList.get(numSize-1).intValue();
        		numSize--;
        		num2 = numList.get(numSize-1).intValue();
        		numSize--;
        		numList.set(numSize, num2-num1);
        		numSize++;
        	}
        	else if ("*".equals(tokens[i])) {
        		num1 = numList.get(numSize-1).intValue();
        		numSize--;
        		num2 = numList.get(numSize-1).intValue();
        		numSize--;
        		numList.set(numSize, num1*num2);
        		numSize++;
        	}
        	else if ("/".equals(tokens[i])) {
        		num1 = numList.get(numSize-1).intValue();
        		numSize--;
        		num2 = numList.get(numSize-1).intValue();
        		numSize--;
        		numList.set(numSize, num2/num1);
        		numSize++;
        	}
        	else {
    			numList.add(Integer.valueOf(tokens[i]));
    			numSize++;
        	}
        }
    	
    	return numList.get(--numSize).intValue();
    }
    
    // Stack is OK, but List failed!
    public static int evalRPN_stack(String[] tokens) {
    	Stack<Integer> numStack = new Stack<Integer>();
        
        for (int i=0; i<tokens.length; ++i) {
        	int num1, num2;
        	if ("+".equals(tokens[i])) {
        		num1 = numStack.pop().intValue();
        		num2 = numStack.pop().intValue();
        		numStack.push(Integer.valueOf(num2 + num1));
        	}
        	else if ("-".equals(tokens[i])) {
        		num1 = numStack.pop().intValue();
        		num2 = numStack.pop().intValue();
        		numStack.push(Integer.valueOf(num2 - num1));
        	}
        	else if ("*".equals(tokens[i])) {
        		num1 = numStack.pop().intValue();
        		num2 = numStack.pop().intValue();
        		numStack.push(Integer.valueOf(num2 * num1));
        	}
        	else if ("/".equals(tokens[i])) {
        		num1 = numStack.pop().intValue();
        		num2 = numStack.pop().intValue();
        		numStack.push(Integer.valueOf(num2 / num1));
        	}
        	else {
        		numStack.push(Integer.valueOf(tokens[i]));
        	}
        }
    	
    	return numStack.pop().intValue();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(
				ReversePolishNotation.evalRPN_stack(
						new String[]{"4", "13", "5", "/", "+"}));
	}

}
