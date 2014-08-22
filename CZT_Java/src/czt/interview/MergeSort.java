package czt.interview;

import czt.util.StaticMethods;

/**
 * Created by: TeaEra;
 * Created date: 2014-08-22;
 *
 * 归并排序：
 *   1. System.arraycopy();
 */
public class MergeSort {

    public static int[] mergeSort(int[] intArr) {
        if (intArr.length <= 1) {
            return intArr;
        }
        int size = intArr.length;
        int mid = size / 2;
        int[] leftPart = new int[mid];
        int[] rightPart = new int[size-mid];
        System.arraycopy(intArr, 0, leftPart, 0,  mid);
        System.arraycopy(intArr, mid, rightPart, 0, size-mid);
        int[] sortedLeftPart = mergeSort(leftPart);
        int[] sortedRightPart = mergeSort(rightPart);
        //
        return merge(sortedLeftPart, sortedRightPart);
    }

    public static int[] merge(int[] leftPart, int[] rightPart) {
        int leftLen = leftPart.length;
        int rightLen = rightPart.length;
        int leftIdx = 0;
        int rightIdx = 0;
        int[] outArr = new int[leftLen + rightLen];
        int currIdx = 0;
        while (leftIdx < leftLen && rightIdx < rightLen) {
            if (leftPart[leftIdx] > rightPart[rightIdx]) {
                outArr[currIdx++] = rightPart[rightIdx++];
            }
            else {
                outArr[currIdx++] = leftPart[leftIdx++];
            }
        }
        while (leftIdx < leftLen) {
            outArr[currIdx++] = leftPart[leftIdx++];
        }
        while (rightIdx < rightLen) {
            outArr[currIdx++] = rightPart[rightIdx++];
        }
        return outArr;
    }

    public static void main(String[] args) {
        int[] intArr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        System.out.println(">>> Original:");
        StaticMethods.showArray(intArr);

        // Sort the array;
        int[] outArr = MergeSort.mergeSort(intArr);
        System.out.println(">>> Sorted:");
        StaticMethods.showArray(outArr);
    }
}
