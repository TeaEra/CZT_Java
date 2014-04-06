package czt.learn.CrackCode.Chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * Created by: TeaEra;
 * Created date: 14-4-2;
 */
public class BitManipulation {

    /******************************************************************************************************************/
    /**
     * All problems in Chapter 5;
     */

    // Problem 5.1
    // i<j;
    public static int problem5_1(int n, int m, int i, int j) {
        // Get left part;
        int leftPart = n >> j;

        // Get all-one mask for right part;
        int rightMask = (1 << i) - 1;
        int rightPart = n & rightMask;

        int temp = (leftPart << (j-i+1)) | m;
        temp = temp << i;
        return temp | rightPart;
    }

    // Problem 5.4
    // ((n & (n-1)) == 0) could be used to identify whether n is power of 2 or
    // not;
    public static boolean problem5_4(int n) {
        if ((n & (n-1)) == 0) {
            return true;
        }
        return false;
    }

    // Problem 5.5
    public static int problem5_5(int m, int n) {
        int count = 0;
        for (int xorRes = m^n; xorRes != 0; xorRes = xorRes >> 1) {
            count += xorRes & 1;
        }
        return count;
    }

    // Problem 5.6
    // Swap odd and even bits in an integer
    public static int problem5_6(int num) {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }

    /******************************************************************************************************************/
    /**
     * Some ideas
     */

    // Count the digits in binary format;
    public static int countDigitsInBinary(int num) {
        int count = 0;
        for (int andRes = num; andRes != 0; andRes = andRes >> 1) {
            count++;
        }
        return count;
    }

    // Create the all-one mask;
    public static int getAllOneMask(int numOfDigits) {
        int res = 1;
        return (res << numOfDigits) - 1;
    }

    // Create the all-zero mask;
    public static int getAllZeroMask() {
        return 0;
    }

    // Use all-one mask and 'and'(&) operator;
    public static int andAllOneMask(int num) {
        int numOfDigits = BitManipulation.countDigitsInBinary(num);
        return num & BitManipulation.getAllOneMask(numOfDigits);
    }

    // Use all-zero mask and 'or'(|) operator;
    public static int orAllZeroMask(int num) {
        return num | BitManipulation.getAllZeroMask();
    }

    /******************************************************************************************************************/
    /**
     * All tests;
     */

    // Test 5.1
    public static void test5_1() {
        System.out.println(Integer.toBinaryString(
             BitManipulation.problem5_1(
                 Integer.parseInt("10000000000", 2),
                 Integer.parseInt("10101", 2),
                 2,
                 6
             )
        ));
    }

    // Test 5.4
    public static void test5_4() {
        for (int i=1; i<=16; ++i) {
            System.out.println(">>> " + i + " is power of 2 or not? " + BitManipulation.problem5_4(i));
        }
    }

    // Test 5.5
    public static void test5_5() {
        System.out.println(">>> Steps: " + BitManipulation.problem5_5(31, 14));
    }

    // Test 5.6
    public static void test5_6() {
        for (int i=1; i<=16; ++i) {
            System.out.println(">>> " + Integer.toBinaryString(i) + " - "
                    + Integer.toBinaryString(BitManipulation.problem5_6(i)));
        }
    }

    // Test countDigits()
    public static void testCountDigitsInBinary() {
        List<Integer> testList = Arrays.asList(new Integer(8), new Integer(16), new Integer(32));
        for (Integer eachInt : testList) {
            System.out.println(">>> Number of digits in binary for " + eachInt + ": "
                    + BitManipulation.countDigitsInBinary(eachInt.intValue()));
        }
    }

    // Test getAllOneMask()
    public static void testGetAllOneMask() {
        for (int i=0; i<=8; ++i) {
            System.out.println(">>> " + i + " : "
                    + Integer.toBinaryString(BitManipulation.getAllOneMask(i)));
        }
    }

    // Test andAllOneMask() and orAllZeroMask()
    public static void testTwoMasks() {
        List<Integer> testList = Arrays.asList(new Integer(8), new Integer(16), new Integer(32));
        for (Integer eachInt : testList) {
            System.out.println(">>> " + eachInt);
            System.out.println("And with all-one mask: "
                    + BitManipulation.andAllOneMask(eachInt));
            System.out.println("Or with all-zero mask: "
                    + BitManipulation.orAllZeroMask(eachInt));
        }
    }

    /******************************************************************************************************************/
    /**
     * The main portal;
     *
     * @param args
     */
    public static void main(String[] args) {

        // 5.1
        BitManipulation.test5_1();
        // 5.4;
        //BitManipulation.test5_4();
        // 5.5;
        //BitManipulation.test5_5();
        // 5.6;
        //BitManipulation.test5_6();

        // countDigitsInBinary();
        //BitManipulation.testCountDigitsInBinary();
        // getAllOneMask();
        //BitManipulation.testGetAllOneMask();
        // andAllOneMask(); orAllZeroMask();
        //BitManipulation.testTwoMasks();
    }
}
