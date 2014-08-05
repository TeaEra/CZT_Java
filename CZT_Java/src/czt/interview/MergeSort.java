package czt.interview;

import czt.util.StaticMethods;

/**
 * Created by: TeaEra;
 * Created date: 2014-08-05;
 */
public class MergeSort {

    public void mergeSort(int[] intArr, int start, int end) {
        if (start == end) {
            return;
        }
        else if (start + 1 == end) {
            return;
        }
        else {
            int mid = (start + end) / 2;
            mergeSort(intArr, start, mid);
            mergeSort(intArr, mid+1, end);
        }
    }

    public static void main(String[] args) {
        int[] intArr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        System.out.println(">>> Original:");
        StaticMethods.showArray(intArr);

        // Sort the array;
    }
}
