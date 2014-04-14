package czt.learn.XXX_Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by: TeaEra;
 * Created date: 2014/4/12;
 */
public class XXX_Test {

    public static void main(String[] args) {
        List<String> testStringArr = Arrays.asList(
            "/abc",
            "abc\\",
            "abcd\"",
            "abc",
            "a",
            "/ \\ \""
        );

        // ??? Could not detect these 3 kinds of symbols, using following codes:
        Pattern pattern = Pattern.compile("[(\\\")/(\\\\)]{1}");
        for (String s : testStringArr) {
            Matcher matcher = pattern.matcher(s);
            System.out.println(">>> " + s + " : " + matcher.matches());
        }
    }
}
