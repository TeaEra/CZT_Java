package czt.learn.leetcode;

import java.util.ArrayList;

public class PascalTriangle {
    
	// I think this could be optimized later!!!
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
        	return res;
        }
        if (numRows == 1) {
        	ArrayList<Integer> temp = new ArrayList<Integer>();
        	temp.add(1);
        	res.add(temp);
        	return res;
        }

    	ArrayList<Integer> firstList = new ArrayList<Integer>();
    	firstList.add(1);
    	res.add(firstList);
    	for (int i=1; i<numRows; ++i) {
    		ArrayList<Integer> prev = res.get(i-1);
    		ArrayList<Integer> temp = new ArrayList<Integer>(i+1);
    		for (int l=0; l<i+1; ++l) {
    			temp.add(0);
    		}
    		temp.set(0, prev.get(0));
    		temp.set(i, prev.get(prev.size() - 1));
    		
    		for (int j=1; j<i; ++j) {
    			temp.set(j, Integer.valueOf(prev.get(j-1).intValue()
    					+ prev.get(j).intValue()));
    		}
    		res.add(temp);
    	}
    	
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> res = PascalTriangle.generate(5);
		System.out.println("[");
		for (ArrayList<Integer> each : res) {
			System.out.print("[");
			for (int i=0; i<each.size(); ++i) {
				System.out.print(each.get(i));
				if (i != each.size()-1) {
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
		System.out.println("]");
	}

}
