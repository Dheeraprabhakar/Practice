import java.util.*;
public class Prime {
    public static void main(String args[]){
        int primeBelow = 1000;
        Boolean[] primes = new Boolean[primeBelow+1];
        Arrays.fill(primes, true);
        //int count=0;
        for(int i=2;i<=primeBelow;i++){
            if(primes[i]){
                for(int j=i+i;j<=primeBelow;j=j+i){
                    primes[j]=false;
                }
            }
        }
        for(int k=2;k<primes.length;k++){
            if(primes[k]){
                System.out.println(k);
            }
        }
    }

   // populateMapWithMultiples(x)
}
