import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Length {
    public static void main(String args[]){
        // TODO: Write your code here
        Map<Character, Integer> s = new HashMap<>();
        String str = "araaci";
        int k=2;
        int count=0;
        int startIndex = 0;
        int longestStringLength= 0;
        int totalvals = 0;
        for(int i=0;i<str.length();i++){
            s.put(str.charAt(i), s.getOrDefault(str.charAt(i),0)+1);
            //totalvals = totalvals +1;
            while(s.size()>k){
               char leftChar =  str.charAt(startIndex);
                s.put(str.charAt(startIndex), s.get(leftChar)-1);
                if(s.get(leftChar)==0){
                    s.remove(leftChar);
                }

                startIndex++;
            }
            longestStringLength = Math.max(longestStringLength, i - startIndex + 1);
        }




        System.out.println(longestStringLength);
        String abc = "leetcode.code.com";
        String[] a = abc.split("\\.",2);
        System.out.println(a[0]+"--"+a[1]);
    }
}
