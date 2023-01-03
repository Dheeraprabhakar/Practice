public class StringPermutation {
    //Function for swapping the characters at position I with character at position j
    public static String swapString(String a, int i, int j) {
        char[] b =a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }

    public static void main(String[] args)
    {
        String searchString = "eidbcaoo";

        String str = "bicd";
        int len = str.length();
        System.out.println("All the permutations of the string are: "+ str.contains(searchString));
        boolean found = generatePermutation(str, 0, len, searchString);
        System.out.println(searchString+" " + found +" a substring of "+str);
    }

    //Function for generating different permutations of the string
    public static boolean generatePermutation(String str, int start, int end, String searchString)
    {
        //Prints the permutations
        if (start == end-1) {
            if(searchString.contains(str)){
                return true;
            } else{
                System.out.println(str);
                return false;
            }

        }
        else
        {
            for (int i = start; i < end; i++)
            {
                //Swapping the string by fixing a character
                str = swapString(str,start,i);
                //System.out.println("str ="+str);
                //Recursively calling function generatePermutation() for rest of the characters
                if(generatePermutation(str,start+1,end, searchString)){
                    return true;
                };
                //Backtracking and swapping the characters again.
                str = swapString(str,start,i);
            }
        }
        return false;
    }
}