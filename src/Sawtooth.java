public class Sawtooth {
    public static void main(String args[]) {
         int arr[] = new int[]{1, 2, 1, 4, 5, 6, 4, 3, 7};
         int length=1;
         for(int i=0;i<arr.length;i++){
             for(int j=i+1;j<arr.length;j++){
                 if(arr[i]>arr[j] && arr[i+1]<arr[j+1] || (arr[i]<arr[j] && arr[i+1]>arr[j+1])){
                     length=length+2;
                 }
             }
         }
    }

}
