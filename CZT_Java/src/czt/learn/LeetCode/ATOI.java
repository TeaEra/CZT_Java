package czt.learn.leetcode;

public class ATOI {
	
    public static int atoi(String str) {
        if (str == null || str == "") return 0;
        
        StringBuilder integerSb = new StringBuilder();
        char signChar = '+';
        char lastChar;
        boolean isGetInteger = false;
        
        for (int i=0; i<str.length(); ++i) {
        	char currChar = str.charAt(i);
        	lastChar = currChar;
        	
        	if (currChar == ' ') {
        		continue;
        	}
        	else if (currChar >= '0' && currChar <= '9') {
        		if (lastChar == '-') {
        			signChar = lastChar;
        		}
        		
        		if (! isGetInteger) {
        			integerSb.append(currChar);
        			continue;
        		}
        		break;
        	}
        	else {
        		if (! integerSb.equals("")) {
        			isGetInteger = true;
        			break;
        		}
        		continue;
        	}
        }
        
        if (integerSb.equals("") && ! isGetInteger) return 0;
        
        long longRes = 0;
        for (int i=0; i<integerSb.length(); ++i) {
        	longRes = 10 * longRes 
        			+ Integer.valueOf(integerSb.charAt(i)).intValue();
        }
        
        if (signChar == '-') {
        	longRes = 0-longRes;
        }
        
        if (longRes > Integer.MAX_VALUE || longRes < Integer.MIN_VALUE) {
        	return Integer.MAX_VALUE;
        }
        
        System.out.println(integerSb.toString());
        
        return Long.valueOf(longRes).intValue();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ATOI.atoi("   ");
		ATOI.atoi("+123");
	}

}
