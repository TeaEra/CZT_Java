package czt.learn.LeetCode;

import czt.util.StaticMethods;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] outArr = new int[len+1];
        
        int carry = 1;
        for (int i = len-1; i>=0; --i) {
        	int sum = carry + digits[i];
        	outArr[i+1] = sum % 10;
        	carry = sum / 10;
        }
        
        if (carry != 0) {
        	outArr[0] = carry;
        	return outArr;
        }
        else {
        	int[] realOutArr = new int[len];
        	for (int i=0; i<len; ++i) {
        		realOutArr[i] = outArr[i+1];
        	}
        	return realOutArr;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = new int[]{8, 9, 9};
		StaticMethods.showArray(PlusOne.plusOne(n1));
		
	}

}
