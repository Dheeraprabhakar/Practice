/*You’re given a list of search words typed by different customers in Audible.

[ Great Gadsby, Self Help, The Convicted, Great Gadsby, Hello Nation, Self Help]

Input: Great Gadsby,Self Help
Output: 1

You’re given two search words and your task is to find out the minimum distance between these words in the list.*/


import java.util.ArrayList;
import java.util.List;

public class MinimumDistance{
    public static void main(String args[]){
        String s1 = "Great Gadsby";
        String s2 = "Self Help";
        String[] arrStr = { "Great Gadsby", "The Convicted","Self Help", "Self Help", "Hello Nation", "blah Help", "Great Gadsby"};
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int dist=0;
        int prevFoundindex= 0;
        String found = "";
        int minDist = Integer.MAX_VALUE;
        for(int i=0;i<arrStr.length;i++){
            if(arrStr[i].equals(s1) || arrStr[i].equals(s2)){
                if(arrStr[i].equals(s1)){
                    if(found.equals("s2")){
                        dist = (i-prevFoundindex);
                        minDist = Math.min(minDist, dist);
                    }
                    found="s1";
                    prevFoundindex = i;
                } else if(arrStr[i].equals(s2)){
                    if(found.equals("s1")){
                        dist = (i-prevFoundindex);
                        minDist = Math.min(minDist, dist);

                    }
                    prevFoundindex=i;
                    found="s2";
                }
            }
        }
        System.out.println("Min Dist="+minDist);

    }
}