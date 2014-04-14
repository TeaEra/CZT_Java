package czt.learn.CrackCode.Util;

import java.io.*;
import java.util.logging.Logger;

/**
 * Created by: TeaEra;
 * Created date: 2014/4/6;
 */
public class CrackCodeUtil {

    /** File name to store prime numbers */
    private final static String FILE_PRIME_NUMBERS = "PrimeNumbers.txt";

    //
    public static void getPrimeNumbersToFile() {
        try {
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PRIME_NUMBERS), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //

    }
}
