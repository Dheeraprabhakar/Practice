public class Testing {


        public static void main (String args[]) {
            int k = 3;
            int[] arr = {2, 1, 5, 1, 3, 2};
            // TODO: Write your code here
            int sum = 0;
            //int windowStart = 0;
            int maxSum = 0;
            int windowEnd = 0;
            for(int i=0;i<arr.length;i++){
                sum = sum+arr[i];
                if(i>=k -1){
                    maxSum = Math.max(sum, maxSum);
                    sum = sum - arr[windowEnd];
                    windowEnd++;
                }

            }
            System.out.println(maxSum);
        }
    }

