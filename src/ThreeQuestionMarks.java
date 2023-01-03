public class ThreeQuestionMarks {
    public static void main (String args[]) {
        String str = "arrb6!???4xxbl5???eee5";
        int qCount = 0;
        int total = 0;
        boolean start = false;
        for(int i=0;i<str.length();i++){
            char current = str.charAt(i);

            if(Character.isDigit(current)){

                //convert curr to int
                 int currInt = current-'0';

                if(!start) {
                    total = currInt;
                    start = true;
                    continue;
                } else{
                    total = total + currInt;
                    if(total == 10){
                        if(qCount==3){
                            System.out.println(" It is true");
                            break;
                        } else{
                            qCount = 0;
                            total = currInt;
                            start = true;
                        }
                    }
                }
            }
            if(start){
                if(current=='?'){
                    System.out.println(" found q mark");
                    qCount++;
                }
            }

        }

    }
}
