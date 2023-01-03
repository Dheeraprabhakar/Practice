import java.util.Arrays;
import java.util.List;

class MissingNumber {

    public static void main(String[] args) {
        // TODO: Write your code here
        int[] nums= {4, 0, 3, 1};
        int len = nums.length;
        List lst = Arrays.asList(nums);
        for(int i=0;i<=len;i++){
            if(!lst.contains(i)){
                System.out.println(i);
            }
        }

        System.out.println("-1");
    }
}
