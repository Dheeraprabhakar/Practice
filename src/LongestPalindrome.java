
/*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 
Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
*/

import java.util.*;

class LongestPalindrome {
    public static void main(String a[]){
        LongestPalindrome sol = new LongestPalindrome();
        String result = sol.longestPalindromicSubstring("abacdgdcaba");
        System.out.print("Longest palindrome: "+result);
    }
     String longestPalindromicSubstring(String s) {
        char[] charArr = s.toCharArray();
        int left =0;
        int right =charArr.length-1;
        int longest = Integer.MIN_VALUE;
        Map<Integer, String> palStrings = new HashMap<>();
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i, j+1);
                //System.out.print("i="+i+" j="+j);

                StringBuilder sb = new StringBuilder(sub);
                System.out.println("sub="+sub);
                if(sub.equals(sb.reverse().toString())){
                    System.out.println("Palindrome=="+sub);
                    palStrings.put(sb.length(), sub);
                    longest = Math.max(longest,sb.length());
                }
            }

        }
        return palStrings.get(longest);
    }
}