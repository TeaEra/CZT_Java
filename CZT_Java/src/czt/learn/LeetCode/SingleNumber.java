package czt.learn.LeetCode;

public class SingleNumber {

	// 解释：
	// 使用异或xor，完美将偶数次（这里是2次）出现的数字“抵消”，
	// 最后剩余的就是仅出现1次的数字；
    public static int singleNumber(int[] A) {
        
    	int singleNum = 0;
        
        for (int i=0; i<A.length; ++i) {
        	singleNum ^= A[i];
        }
    	
    	return singleNum;
    }

    // 解释：
    // 使用一个32位的数组，讲每个数字对应二进制位上的值相加，然后
    // 使用 mod 3，获得该位上“残留”数字，再还原为仅出现1次的数字；
    public static int singleNumber_triple(int[] A) {
        
    	int[] bitArr = new int[32];
    	
    	for (int i=0; i<A.length; ++i) {
    		for (int j=0; j<32; ++j) {
    			bitArr[j] += (A[i] >> j) & 1;
    			bitArr[j] %= 3;
    		}
    	}
    	
    	int singleNum = 0;
    	for (int i=0; i<32; ++i) {
    		singleNum += (bitArr[i] << i);
    	}
    	
    	return singleNum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(SingleNumber.singleNumber(new int[]{1,1,2,3,2}));
		System.out.println(SingleNumber.singleNumber_triple(new int[]{1,1,2,1,2,3,2}));
	}

}
