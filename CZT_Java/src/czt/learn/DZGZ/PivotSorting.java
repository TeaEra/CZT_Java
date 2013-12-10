package czt.learn.DZGZ;


public class PivotSorting {
	
	// PivotSort + PivotPartition = QuickSort
	// Here, I choose the first element as the pivot;
	// Similarly, the last element could also be considered as the pivot;
	// Then
	// TODO: randomized QuickSort
	// which means to choose pivot randomly;
	
	// Part1
	public static void pivotSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = pivotPartition(arr, start, end);
			PivotSorting.pivotSort(arr, start, mid-1);
			PivotSorting.pivotSort(arr, mid+1, end);
		}
	}
	
	public static int pivotPartition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int smallIdx = start-1;
		
		for (int i=start+1; i<=end; ++i) {
			if (arr[i] <= pivot) {
				int temp = arr[i];
				smallIdx++;
				arr[i] = arr[smallIdx];
				arr[smallIdx] = temp;
			}
		}
		smallIdx++;
		System.out.println(smallIdx);
		int temp = arr[smallIdx];
		arr[smallIdx] = pivot;
		arr[start] = temp;
		
		return smallIdx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Manually initialize an array for 10 integers
		int[] arr = new int[] {4,6,1,5,8,9,2,3,7,0};
		int start = 0;
		int end = arr.length - 1;
		
		//
		PivotSorting.pivotSort(arr, start, end);
		for (int i=0; i<arr.length; ++i) {
			System.out.print(i + "\t");
		}
	}

}
