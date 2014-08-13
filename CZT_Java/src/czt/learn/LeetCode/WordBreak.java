package czt.learn.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	// ???
    public static boolean wordBreak(String s, Set<String> dict) {
        if (s == null) {
        	return true;
        }
        if (s == "") {
        	return true;
        }
        if (dict.contains(s)) {
        	return true;
        }

    	StringBuffer preSb = new StringBuffer();
        for (int i=0; i<s.length(); ++i) {

        	StringBuffer postSb = new StringBuffer();
        	preSb.append(s.charAt(i));
        	postSb.append(s.substring(i+1, s.length()));
        	
        	//System.out.println(preSb.toString());
        	//System.out.println(postSb.toString());
        	
        	if (dict.contains(preSb.toString()) 
        			&& WordBreak.wordBreak(postSb.toString(), dict)) {
        		return true;
        	}
        }
    	
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(WordBreak.wordBreak(s, dict));
	}

}
