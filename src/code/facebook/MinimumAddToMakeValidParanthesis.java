package code.facebook;

public class MinimumAddToMakeValidParanthesis {

    public static void main(String args[]){

        String str = "()))((";

        MinimumAddToMakeValidParanthesis obj = new MinimumAddToMakeValidParanthesis();

        System.out.println(obj.minAdd(str));
    }

    public int minAdd(String s){

        int openNeeded = 0;
        int closingNeeded = 0;

        for(char c:s.toCharArray()){
            if(c=='('){
                closingNeeded++;
            }
            else if(c==')' && closingNeeded>0){  //only subtract open if they are available
                closingNeeded--;
            }
            else{
                openNeeded++;
            }
        }

        return openNeeded+closingNeeded;
    }
}
