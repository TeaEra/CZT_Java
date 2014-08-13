package czt.learn.leetcode;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int len = 0;
        int lastLen = 0;
        boolean isMeetSpace = false;
        
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                if (! isMeetSpace) {
                    lastLen = len;
                }
                len = 0;
                isMeetSpace = true;
            }
            else {
                len++;
                isMeetSpace = false;
            }
        }
        // In case that the string ends with no space but a word instead;
        // For instance, "a bcd";
        if (! isMeetSpace) {
            lastLen = len;
        }
        return lastLen;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(LengthOfLastWord.lengthOfLastWord("a  "));
	}

}
