import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String args[]){
        int x=900;
        //generate permutations of x
        String strX = ((Integer)x).toString();
        char[] chX = strX.toCharArray();
        List<Integer> res = new ArrayList<>();
        Permutation per = new Permutation();
        per.getPermutations(res, chX, 0, chX.length);
        for(Integer i: res){
            System.out.println(i);
        }
    }
    void getPermutations(List<Integer> res,  char[] chX, int start, int end){
        if(start==end){
            String p="";
            for(char l:chX) {
                p = p + l;
            }
            res.add(Integer.parseInt(p));
        }

        for(int i=start;i<end;i++){
            swap(chX, start, i);
            getPermutations(res,chX,start+1,end);
            swap(chX, start, i);
        }
    }
    void swap(char[] chX, int start, int end){
        char temp = chX[start];
        chX[start]=chX[end];
        chX[end]=temp;
    }
}
