package czt.learn.leetcode;

public class SingleNumber {

	// ���ͣ�
	// ʹ�����xor��������ż��Σ�������2�Σ����ֵ����֡�����
	// ���ʣ��ľ��ǽ�����1�ε����֣�
    public static int singleNumber(int[] A) {
        
    	int singleNum = 0;
        
        for (int i=0; i<A.length; ++i) {
        	singleNum ^= A[i];
        }
    	
    	return singleNum;
    }

    // ���ͣ�
    // ʹ��һ��32λ�����飬��ÿ�����ֶ�Ӧ������λ�ϵ�ֵ��ӣ�Ȼ��
    // ʹ�� mod 3����ø�λ�ϡ����������֣��ٻ�ԭΪ������1�ε����֣�
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
