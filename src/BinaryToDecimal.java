public class BinaryToDecimal {
    public static void main(String a[]){
        int res = 0;
        int[] b= new int[]{1,1,1,1};
        for(int val: b){
            res = res << 1 | val;
        }
        System.out.println("res="+res);

    }
}
