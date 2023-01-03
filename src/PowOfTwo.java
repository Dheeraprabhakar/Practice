public class PowOfTwo {
    public static void main(String args[]){
        int[] a= new int[]{1, -1, 2, 3};
        int count=0;
        PowOfTwo t = new PowOfTwo();
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                int sum = a[i]+a[j];
                if(sum==0){
                    continue;
                }
                if(t.isPow(sum)){
                    System.out.println("i="+a[i]+" j="+a[j]+" sum="+sum);
                    count++;
                }
            }
        }
        System.out.println("count=="+count);
    }
    boolean isPow(int num){
        while(num%2==0){
            num = num/2;
        }
        return num==1?true:false;
    }
}
