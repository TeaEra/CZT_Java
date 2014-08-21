package czt.learn.dzgz;

import czt.util.StaticMethods;

public class InsertionSort {
	
	public static int[] insertionSort(int[] arr) {
		int size = arr.length;
		int[] outArr = new int[size];
		int outSize = 0;
		outArr[outSize] = arr[outSize];
		outSize++;
		
		for (int i=1; i<size; ++i) {
			int currIdx = outSize - 1;
			while (currIdx >= 0 && arr[i] < outArr[currIdx]) {
				currIdx--;
			}
			// Please note that:
			// here we should move from 'outSize-1' to 'currIdx+1';
			for (int j=outSize-1; j>=currIdx+1; --j) {
				outArr[j+1] = outArr[j];
			}
			// Insert the arr[i] at the position currIdx+1;
			outArr[currIdx+1] = arr[i];
			outSize++;
			StaticMethods.showArray(outArr);
		}
		
		return outArr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[]{5,3,1,0,4,2};
		InsertionSort.insertionSort(arr);
	}

}
