package czt.learn.LeetCode;

import czt.util.StaticMethods;

import java.util.ArrayList;

/**
 * Created by TeaEra on 14-2-16.
 */
public class LetterCombinationsOnPhone {

    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> outList = new ArrayList<String>();
        if (digits.length() == 0) {
            outList.add("");
            return outList;
        }

        for (int i=0; i<digits.length(); ++i) {
            int currDigit = Integer.valueOf(digits.substring(i,i+1)).intValue();
            StringBuffer corrLetters = new StringBuffer();
            switch (currDigit) {
                case 2:
                    corrLetters.append("abc");
                    break;
                case 3:
                    corrLetters.append("def");
                    break;
                case 4:
                    corrLetters.append("ghi");
                    break;
                case 5:
                    corrLetters.append("jkl");
                    break;
                case 6:
                    corrLetters.append("mno");
                    break;
                case 7:
                    corrLetters.append("pqrs");
                    break;
                case 8:
                    corrLetters.append("tuv");
                    break;
                case 9:
                    corrLetters.append("wxyz");
                    break;
                default:
                    break;
            }
            if (outList.size() == 0) {
                //
                for (int k=0; k<corrLetters.length(); ++k) {
                    outList.add(corrLetters.substring(k, k+1));
                }
            }
            else {
                ArrayList<String> tempList = new ArrayList<String>();
                for (int j=0; j<outList.size(); ++j) {
                    for (int k=0; k<corrLetters.length(); ++k) {
                        //
                        tempList.add(outList.get(j) + corrLetters.substring(k, k+1));
                    }
                }
                outList = tempList;
            }
        }

        return  outList;
    }

    public static void main(String[] args) {

        //
        StaticMethods.showArrayList(LetterCombinationsOnPhone.letterCombinations("23"));
    }
}
