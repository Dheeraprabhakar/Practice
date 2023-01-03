/*
Given an array nums of integers and integer k,
return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k.
If no i, j exist satisfying this equation, return -1.


Example 1:

Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
 */

import java.util.Arrays;

public class SumClosestToZero {
    public static void main (String args[]) {
        int k=15;
        int[] nums = {10,20,30};
        // int[] nums = {34,23,1,24,75,33,54,8}; int k=60;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        //1, 8, 23, 24, 33, 34, 54, 75
        int left=0, right =nums.length-1;
        while(left<right){
            sum = nums[left]+nums[right];
            if(sum<k){
                maxSum = Math.max(maxSum, sum);
                left++;
            }
            if(sum>=k) {
                right--;
            }

        }

        int finalVal = maxSum==Integer.MIN_VALUE?-1:maxSum;
        System.out.println("finalVal="+finalVal);
    }

}
