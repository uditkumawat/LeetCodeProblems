package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-iii/discuss/152092/O(n)-Java-Recursive-Simple-Solution
//TC- O(N)
//SC - O(N) queue
public class BasicCalculatorIII {

    public static int index = 0;

    public static void main(String args[]){

        String str = "2*(5+5*2)/3+(6/2+8)";

        System.out.println(calculate(str));
    }

    public static int calculate(String str){

        Queue<Character> tokens = new LinkedList<>();
        for(char c:str.toCharArray()){
            if(c!=' '){
                tokens.add(c);
            }
        }
        tokens.add('+');   // this is very important for getting last sum  , this will satisfy condition i == str.length-1

        return calculate(tokens);
    }

    public static int calculate(Queue<Character> tokens){

        char preOp = '+';
        int currNumber = 0;
        int result = 0;
        int lastNumber = 0;

        while(!tokens.isEmpty()){
            char c = tokens.poll();

            if(isNumber(c)){
                currNumber = currNumber*10 + c-'0';
            }
            else if(c=='('){
                currNumber = calculate(tokens);
            }
            else{
                if(preOp=='+' || preOp=='-'){
                    result+=lastNumber;
                    lastNumber = preOp=='+'?currNumber:-currNumber;
                }
                else if(preOp=='*'){
                    lastNumber = lastNumber*currNumber;
                }
                else if(preOp=='/'){
                    lastNumber = lastNumber/currNumber;
                }

                if(c==')'){
                    break;
                }

                preOp = c;
                currNumber = 0;
            }
        }

        return result+lastNumber;
    }

    public static boolean isNumber(char c){
        return c>='0' && c<='9';
    }
}
