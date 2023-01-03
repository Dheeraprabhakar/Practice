public class Testing2 {

    public static void main (String args[]) {
        int k = 8;
        int[] arr = { 2, 1, 1, 1, 1 ,1};
        // TODO: Write your code here
        int sum = 0;
        //int windowStart = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int smallestWindow = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            sum = sum+arr[i];
            while(sum>=k){
                smallestWindow = Math.min(smallestWindow, (i - windowStart)+1);
                sum = sum -arr[windowStart];
                windowStart++;
            }
        }
//        System.out.println("windowStart = "+windowStart);
//        System.out.println("windowEnd = "+windowEnd);
        System.out.println("smallestWindow = "+(smallestWindow == Integer.MAX_VALUE ? 0 : smallestWindow));

    }
}

