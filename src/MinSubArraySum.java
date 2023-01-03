// Given an array of n positive integers and a positive target s, find the
// minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
// Input: s = 11, nums = [1,2,3,4,5,6]
// Output: 2
// Input: s = 19, nums = [5,8,2,9,7,1]
// Output: 3




import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinSubArraySum {
     int minLengthSubArr(int[] nums, int sum) {
         int total =0;
         int start=0, end = 0;
         int minLength = Integer.MAX_VALUE;
         while(start<=end && end<nums.length && start<nums.length){
             total = total + nums[end];
             System.out.println("Tot sum="+total);

             while(total>=sum && start<=end){
                 total = total-nums[start];
                 minLength = Math.min(minLength, end-start+1);
                 if(total>=sum){
                     minLength = Math.min(minLength, end-start);
                     System.out.println("minLength="+minLength);
                     System.out.println("start element="+nums[start]);
                     System.out.println("end element="+nums[end]);
                 }
                 start++;
             }

             end++;
         }
         return minLength==Integer.MAX_VALUE?0:minLength;
    }

    public static void main(String[] args) {

        int sum=6;
        int[] nums=new int[]{10,2,3};
        int length = new MinSubArraySum().minLengthSubArr(nums, sum);
        System.out.println("Final Min length="+length);
    }
}
