public class SubStringFreqPractice {
    int MAX_LEN = 40;
    int ALPH = 26;
     int[][] freq = new int[MAX_LEN][ALPH];
    public static void main(String args[]) {
        String s = "ccpitalone creditcard";
        System.out.println(s.substring(0,2));
        char c = 't';
        SubStringFreqPractice o = new SubStringFreqPractice();
        o.constructFreqMatrix(s);

        o.getCharFreqBetweenIndices(c, 3, 20);
        o.getCharFreqBetweenIndices('c', 0, 2);
    }

    private void getCharFreqBetweenIndices(char c, int start, int end) {

        int endFre = freq[end][c-'a']; // 2
        int startFre = freq[start][c-'a']; // 1

        System.out.println(endFre-startFre);

    }

    void constructFreqMatrix(String s){

        // 0 - 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
        // 1 - 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
        // 2 - 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

        for(int i=1;i<=s.length();i++){
                if(Character.isAlphabetic(s.charAt(i-1))) {
                    freq[i][s.charAt(i-1) - 'a']++;
                }
            }

        // 0 - 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
        // 1 - 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
        // 2 - 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
        // 3 - 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<26;j++){
                freq[i][j]=freq[i][j]+freq[i-1][j];
            }
        }
    }
}
