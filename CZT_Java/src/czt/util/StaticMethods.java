package czt.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaticMethods {

	// To display the List
	public static void showList(List<Object> inList) {
		if (inList == null || inList.size() == 0) {
			System.out.println(">>>Empty List!");
		}
		
		for (int i=0; i<inList.size(); ++i) {
			System.out.print(inList.get(i).toString() + " ");
		}
		System.out.println();
	}
	
	// To display the int array
	public static void showArray(int[] inArr) {
		if (inArr == null || inArr.length == 0) {
			System.out.println(">>>Empty Array!");
		}
		
		for (int i=0; i<inArr.length; ++i) {
			System.out.print(inArr[i] + " ");
		}
		System.out.println();
	}

    //
    public static void showArrayList(ArrayList<String> inArrayList) {
        if (inArrayList == null || inArrayList.size() == 0) {
            System.out.println(">>>Empty List!");
        }

        for (int i=0; i<inArrayList.size(); ++i) {
            System.out.println(inArrayList.get(i) + " ");
        }
    }
	
}
