package czt.learn.LeetCode;

public class RomanNumeral {
    
	// Very 'violent' transform by CZT;
	public static String intToRoman(int num) {
        
		int[] digits = new int[4];
		digits[0] = num / 1000;
		digits[1] = num / 100 % 10;
		digits[2] = num / 10 % 10;
		digits[3] = num % 10;
		
		StringBuffer sb = new StringBuffer();
		
		if (digits[0] != 0) {
			for (int i=0; i<digits[0]; ++i) {
				sb.append("M");
			}
		}
		
		if (digits[1] != 0) {
			if (digits[1] <= 3) {
				for (int i=0; i<digits[1]; ++i) {
					sb.append("C");
				}
			}
			else if (digits[1] == 4) {
				sb.append("CD");
			}
			else if (digits[1] == 9) {
				sb.append("CM");
			}
			else {
				sb.append("D");
				for (int i=0; i<digits[1] - 5; ++i) {
					sb.append("C");
				}
			}
		}
		
		if (digits[2] != 0) {
			if (digits[2] <= 3) {
				for (int i=0; i<digits[2]; ++i) {
					sb.append("X");
				}
			}
			else if (digits[2] == 4) {
				sb.append("XL");
			}
			else if (digits[2] == 9) {
				sb.append("XC");
			}
			else {
				sb.append("L");
				for (int i=0; i<digits[2] - 5; ++i) {
					sb.append("X");
				}
			}
		}
		
		if (digits[3] != 0) {
			if (digits[3] <= 3) {
				for (int i=0; i<digits[3]; ++i) {
					sb.append("I");
				}
			}
			else if (digits[3] == 4) {
				sb.append("IV");
			}
			else if (digits[3] == 9) {
				sb.append("IX");
			}
			else {
				sb.append("V");
				for (int i=0; i<digits[3] - 5; ++i) {
					sb.append("I");
				}
			}
		}
		
		return sb.toString();
    }
	

    public static int romanToInt(String s) {
        
    	int res = 0;
    	
    	int[] arr = new int[s.length()];
    	for (int i=0; i<s.length(); ++i) {
    		if (s.charAt(i) == 'M') {
    			arr[i] = 1000;
    		}
    		else if (s.charAt(i) == 'D') {
    			arr[i] = 500;
        	}
    		else if (s.charAt(i) == 'C') {
    			arr[i] = 100;
        	}
    		else if (s.charAt(i) == 'L') {
    			arr[i] = 50;
        	}
    		else if (s.charAt(i) == 'X') {
    			arr[i] = 10;
        	}
    		else if (s.charAt(i) == 'V') {
    			arr[i] = 5;
        	}
    		else if (s.charAt(i) == 'I') {
    			arr[i] = 1;
        	}
    	}
    	
    	for (int i=0; i<s.length()-1; ++i) {
    		if (arr[i] >= arr[i+1]) {
    			res += arr[i];
    		}
    		else {
    			res -= arr[i];
    		}
    	}
    	res += arr[s.length() - 1];
    	
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(RomanNumeral.intToRoman(1998));
		System.out.println(RomanNumeral.romanToInt("MCMXCVIII"));
	}

}
