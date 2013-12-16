package czt.learn.Util;

import java.util.List;

public class StaticMethods {

	// To display the List
	public static void showList(List<Object> inList) {
		if (inList == null) {
			System.out.println(">>>Empty List!");
		}
		
		for (int i=0; i<inList.size(); ++i) {
			System.out.print(inList.get(i).toString() + " ");
		}
		System.out.println();
	}
	
	// To display the int array
	public static void showArray(int[] inArr) {
		if (inArr == null) {
			System.out.println(">>>Empty Array!");
		}
		
		for (int i=0; i<inArr.length; ++i) {
			System.out.print(inArr[i] + " ");
		}
		System.out.println();
	}
	
}
