import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SubArraysFixedLen {
    public static void main(String a[]) {
        Properties properties = new Properties();
        String[] values = new String[]{};
        int[] nums = new int[]{};
        try {

            InputStream inputStream =
                    SubArraysFixedLen.class.getClassLoader().getResourceAsStream("input.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream ));

//            BufferedReader br = new BufferedReader(new FileReader("input.csv"));
                String line;
                while ((line = br.readLine()) != null) {
                   values = line.split(",");
                }
                nums = new int[values.length];
                for(int i = 0;i < values.length;i++)
                {
                    nums[i] = Integer.parseInt(values[i]);
                }

        } catch(Exception e){
            System.out.println("exiting");
        }


        int k = 360;
        int right = 0;
        int left = 0;
        Set<Integer> tempset = new HashSet<Integer>();
        List<Integer[]> result = new ArrayList<>();
        while(right<nums.length || left<nums.length){
            if(right > nums.length-1){
                left++;
                tempset.clear();
                right = left;
            }
            if(right >= nums.length &&  left >= nums.length){
                break;
            }
            if(!tempset.add(nums[right]) || tempset.size()==k){
                if(tempset.size()==k){
                    Integer[] subarr = getSubArray(left, right, nums);
                    result.add(subarr);
                }
                right++;
                continue;
            }

        }
        System.out.println(result.size());

    }
    static Integer[] getSubArray(int left, int right, int[] nums){
        Integer[] res = new Integer[right-left+1];
        for(int i=left, index=0;i<right+1;i++,index++){
            res[index] = nums[i];
        }
        return res;
    }
}
