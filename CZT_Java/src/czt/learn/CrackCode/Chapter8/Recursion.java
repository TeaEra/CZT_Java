package czt.learn.CrackCode.Chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by: TeaEra;
 * Created date: 2014/4/5;
 */
public class Recursion {

    /******************************************************************************************************************/
    // Problem 8.1;
    // Desc: Fibonacci number;
    public static int problem5_1(int n, List<Integer> fibArr) {
        // Error condition;
        if (n < 1) {
            return -1;
        }
        if (n == 0) {
            if (fibArr.size() == 0) {
                fibArr.add(new Integer(0));
            }
            return fibArr.get(0).intValue();
        }
        if (n == 1) {
            if (fibArr.size() == 1) {
                fibArr.add(new Integer(1));
            }
            return fibArr.get(1).intValue();
        }
        if (fibArr.size() == n) {
            fibArr.add(new Integer(fibArr.get(n-1).intValue() + fibArr.get(n-2).intValue()));
        }
        return fibArr.get(n).intValue();
    }

    // Problem 8.3;
    public static void problem8_3(Set<Integer> set) {
    }

    // Problem 8.8;
    // 8-queen;
    public static void problem8_8() {
    }

    /******************************************************************************************************************/
    // Test 5.1;
    public static void test5_1() {
        List<Integer> fibArr = new ArrayList<Integer>(100);
        for (int i=0; i<=16; ++i) {
            System.out.println(">>> Fibonacci number for " + i + " : "
                    + Recursion.problem5_1(i, fibArr));
        }
    }

    /******************************************************************************************************************/
    /**
     * Main portal;
     *
     * @param args
     */
    public static void main(String[] args) {
        // 5.1
        Recursion.test5_1();
    }
}
