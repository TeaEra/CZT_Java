package czt.learn.DZGZ;

import java.util.ArrayList;
import java.util.List;

import czt.learn.Util.Constants;

public class PivotSorting {
	
	public static void pivotSort() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//
		System.out.print("How many input numbers: ");
		int size = Constants.scanner.nextInt();
		List<Integer> inList = new ArrayList<Integer>();
		for (int i=0; i<size; ++i) {
			inList.add(new Integer(Constants.scanner.nextInt()));
		}
	}

}
