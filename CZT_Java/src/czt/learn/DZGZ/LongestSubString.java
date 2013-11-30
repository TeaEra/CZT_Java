package czt.learn.DZGZ;

import java.util.HashMap;


public class LongestSubString {

	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * 
	 * @param input
	 * @return void
	 * The solution1 is a straight-forward solution to the longest substring
	 * problem; There are also some checkings to avoid duplicate scenarios;
	 */
	public static void solution1(String input) {
		HashMap<String, Integer> charMap = new HashMap<String, Integer>();
		// Init the HashMap: -1 for every char
		for (int i=0; i<alphabet.length(); ++i) {
			charMap.put(String.valueOf(alphabet.charAt(i)), new Integer(-1));
		}
		
		int start = 0;
		int currLen = 0;
		int maxLen = 0;
		int inputLen = input.length();
		StringBuffer sb = new StringBuffer();
		
		outer:
		while (start+currLen <= inputLen) {
			inner:
			for (int currIdx=0; start+currIdx < inputLen; ++currIdx) {
				String currChar = String.valueOf(input.charAt(start + currIdx));
				if (charMap.get(currChar).intValue() == -1) {
					charMap.put(currChar, new Integer(currIdx));
					sb.append(currChar);
					currLen += 1;
				}
				else {
					System.out.println("======");
					System.out.println(sb.toString());
					System.out.println("Start: " + start);
					System.out.println("CurrLen: " + currLen);
					// The following check could avoid the meaningless substrings;
					// Eg. 'abcacfar'
					// After already detecting the 'cfar', it would keep detecting
					// 'far' 'ar' 'r' without this checking below;
					if (start + currLen == inputLen) {
						break outer;
					}
					// Record the max length
					if (currLen > maxLen) {
						maxLen = currLen;
					}
					// Locate the new starting position
					start = start + charMap.get(currChar).intValue() + 1;
					// Reset the length storer
					currLen = 0;
					// Reset the HashMap
					for (int i=0; i<sb.length(); ++i) {
						charMap.put(sb.substring(i, i+1), new Integer(-1));
					}
					// Reset the StringBuffer
					sb.delete(0, sb.length());
					break inner;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "abcacfar";
		LongestSubString.solution1(test1);
	}

}
