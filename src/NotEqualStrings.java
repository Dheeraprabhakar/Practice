public class NotEqualStrings {
public static void main(String args[]){
    NotEqualStrings x  = new NotEqualStrings();
    int p = x.solution("ababca");

    System.out.println("count="+p);
}
    int solution(String s) {
        char[] carray = s.toCharArray();
        int count=0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1; j<s.length()-1; j++){
                System.out.println("-------------");
                String s1 = s.substring(0, i+1);
                String s2= s.substring(i+1, j+1);
                String s3= s.substring(j+1);
                String a = s1+s2;
                String b = s2+s3;
                String c = s3+s1;
                System.out.println(" s1="+s1);
                System.out.println(" s2="+s2);
                System.out.println(" s3="+s3);
                if(!a.equals(b) && !b.equals(c) && !c.equals(a)){

                    System.out.println(" None equal");
                    count++;
                }
            }
            System.out.println("**** one i done ****");
        }
        System.out.println("count="+count);
        return count;
    }

}

/**
 *
 * You are given a string s. Your task is to count the number of ways of splitting s into three non-empty parts a, b and c (s = a + b + c) in such a way that a + b, b + c and c + a are all different strings.
 *
 * NOTE: + refers to string concatenation.
 *
 * Example
 *
 * For s = "xzxzx", the output should be solution(s) = 5.
 *
 * Consider all the ways to split s into three non-empty parts:
 *
 * If a = "x", b = "z" and c = "xzx", then all a + b = "xz", b + c = "zxzx" and c + a = xzxx are different.
 * If a = "x", b = "zx" and c = "zx", then all a + b = "xzx", b + c = "zxzx" and c + a = zxx are different.
 * If a = "x", b = "zxz" and c = "x", then all a + b = "xzxz", b + c = "zxzx" and c + a = xx are different.
 * If a = "xz", b = "x" and c = "zx", then a + b = b + c = "xzx". Hence, this split is not counted.
 * If a = "xz", b = "xz" and c = "x", then all a + b = "xzxz", b + c = "xzx" and c + a = xxz are different.
 * If a = "xzx", b = "z" and c = "x", then all a + b = "xzxz", b + c = "zx" and c + a = xxzx are different.
 * Since there are five valid ways to split s, the answer is 5.
 */
