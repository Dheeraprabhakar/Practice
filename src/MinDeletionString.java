import java.util.*;

public class MinDeletionString {
    public static void main(String a[]){
        String s= "bbcebab";
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        int minVal = Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<Integer>(hm.values());
        Collections.sort(list);
        Set<Integer> setvals = new HashSet<Integer>();
        int res = 0;
        int finalVal = 0;
        for(int occurences: list){
            if(!setvals.add(occurences)) {
                res = occurences;
                while (!setvals.add(res)) {
                    res--;
                }
                if(res==0){
                    setvals.remove(res);
                }
                finalVal = finalVal + (occurences - res);
            }
        }

        System.out.println(finalVal);
    }
}
