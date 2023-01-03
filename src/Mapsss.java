import java.util.*;

class LexicographicallySmaller {
    public static void main(String args[]){
        LexicographicallySmaller a= new LexicographicallySmaller();
       String res =  a.solution("dce", "cccbd");
        System.out.println("RESULT ="+res);
    }
    String solution(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> mp = new HashMap<>();
        int j = 0, i = 0;
        for (j = 0, i = 0; j < s2.length() && i < s1.length(); ) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            System.out.println(" c1=" + c1 + " c2=" + c2);

            if (mp.get(c1)<mp.get(c2)) {
                System.out.println(" c1<c2");
                if(mp.get(c1)<1) {
                    sb.append(c1);
                }
                mp.put(c1, mp.getOrDefault(c1, 0) + 1);
                i++;
            } else if(mp.get(c1)>mp.get(c2)){
                System.out.println(" c1>=c2");
                if(mp.get(c2)<1) {
                    sb.append(c2);
                }

                mp.put(c2, mp.getOrDefault(c2, 0) + 1);

                j++;
            }
            System.out.println("word=" + sb.toString());

        }
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        if (s1.length() > s2.length()) {
            while (i < s1.length()) {
                sb.append(s1.charAt(i++));
            }
        } else {
            while (j < s2.length()) {
                sb.append(s2.charAt(j++));
            }
        }

        return sb.toString();
    }
}
/**
 * You'd like to make your language more unique, so for your merge function,
 * instead of comparing the characters in the usual lexicographical order,
 * you'll compare them based on how many times they occur in their respective initial strings
 * (fewer occurrences means the character is considered smaller).
 * If the number of occurrences are equal, then the characters should be compared in the usual
 * lexicographical way. If both number of occurences and characters are equal,
 * you should take the characters from the first string to the result.
 * Note that occurrences in the initial strings are compared - they do not change over the merge process.
 *
 * Given two strings s1 and s2, return the result of the special merge function you are implementing.
 *
 * Example
 *
 * For s1 = "dce" and s2 = "cccbd", the output should be
 * solution(s1, s2) = "dcecccbd".
 */