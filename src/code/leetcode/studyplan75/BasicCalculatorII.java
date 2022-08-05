package code.leetcode.studyplan75;

//https://www.youtube.com/watch?v=VZkc18pOCkY
//TC - O(N)
//https://leetcode.com/problems/basic-calculator-ii/solution/
public class BasicCalculatorII {


    public int calculate(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int len = s.length();
        int curr = 0;
        int lastNumber = 0;
        int result = 0;
        char operation = '+';

        for(int i=0;i<len;i++){

            char currentChar = s.charAt(i);

            if(Character.isDigit(currentChar)){
                curr = curr*10 + currentChar-'0';
            }

            if(!Character.isDigit(currentChar) &&
                    !Character.isWhitespace(currentChar) || i==len-1){

                if(operation=='+' || operation=='-'){
                    result+=lastNumber;
                    lastNumber = (operation=='+')?curr:-curr;
                }
                else if(operation=='*'){
                    lastNumber = lastNumber * curr;
                }
                else if(operation=='/'){
                    lastNumber = lastNumber / curr;
                }

                operation = currentChar;
                curr = 0;
            }
        }

        return result+lastNumber;
    }

}
