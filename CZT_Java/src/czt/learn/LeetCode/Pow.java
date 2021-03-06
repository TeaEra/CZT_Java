package czt.learn.leetcode;

public class Pow {
	
    public static double pow(double x, int n) {
    	if (x == 1.0) {
    		return 1.0;
    	}
    	else if (x == -1.0) {
    		if (n%2 == 0) {
    			return 1.0;
    		}
    		else {
    			return -1.0;
    		}
    	}
    	
        if (n < 0) {
        	return 1 / pow(x, 0-n);
        }
        if (n == 0) {
        	return 1.0;
        }
        if (n == 1) {
        	return x;
        }
        
        if (n % 2 == 0) {
        	double half = pow(x, n/2);
        	return half*half;
        }
        else {
        	double half = pow(x, (n-1)/2);
        	return x*half*half;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Pow.pow(2.0, 4));
	}

}
