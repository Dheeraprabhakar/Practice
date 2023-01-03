/*
Substring frequency (write function to return substring of string)
Write a function to return the frequency of a character in any substring of a string.
S = “CAPITALONE” C=”A” …. STARTING INDEX 0 AND END INDEX 7
Assume you need a capability to scale out …search for multiple chars in the (use char array for initial string….use for loop)

 */
public class SubStringFreq {
    static int MAX_LEN = 1005;
    static int MAX_CHAR = 26;

    // To store count of all character for all end index
    static int [][]cnt = new int[MAX_LEN][MAX_CHAR];

    // To pre-process string from
// 0 to size of string
    static void preProcess(String s)
    {
        int n = s.length();

        // Store occurrence of
        // character i

        for (int i = 0; i <= n; i++) {
            if(Character.isAlphabetic(s.charAt(i))) {
                cnt[i][s.charAt(i) - 'a']++;
            }
        }

        // Store occurrence o
        // all character upto i
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < 26; j++)
                cnt[i][j] += cnt[i - 1][j];
        }
    }

    // To return occurrence of
// character in range l to r
    static int findCharFreq(int l, int r, char c)
    {
        // Return occurrence of character
        // from 0 to r minus its
        // occurrence from 0 to l
        return (cnt[r][(c) - 97] - cnt[l][(c) - 97]);
    }

    // Driver Code
    public static void main(String[] args)
    {
        //String s = "ccpitalone creditcard";
        String s = "ggeksforgeeks";
        int Q = 4;
        preProcess(s);

        System.out.println(findCharFreq(0, 2, 'g'));
        System.out.println(findCharFreq(2, 6, 'f'));
        System.out.println(findCharFreq(4, 7, 'm'));
        System.out.println(findCharFreq(0, 12, 'e'));
    }


    public static void main2(String args[]){
        String s="aksjhdjka kajshdjka  asjkakjsdjaksh";
        char c = 'j';
        int start=1, end=35;
        System.out.println(s.substring(0,25));
        System.out.println(s.length());
        if(s.length()<end){
            System.out.println("longer");
        }
        int count=0;
        for(int i=start;i<end;i++){
            if(s.charAt(i)==c){
                count++;
            }
        }
        System.out.println(count);
    }
}

