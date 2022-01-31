package code.facebook;

import java.util.Stack;

public class BasicCalculatorII {

    public static void main(String args[]){

        String s = "3+5/2";
        BasicCalculatorII obj = new BasicCalculatorII();

        System.out.println(obj.calculate(s));

    }
    //SC - O(n)
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int si = 0;
        int num = 0;
        char operator = '+';
        int result = 0;

        while(si<s.length()){

            if(s.charAt(si)==' '){
                while(s.charAt(si)==' '){
                    si++;
                }
            }
            else if(Character.isDigit(s.charAt(si))){

                num = 0;

                while(si<s.length() && Character.isDigit(s.charAt(si))){
                    num = num*10 + s.charAt(si)-'0';
                    si++;
                }

                int res = 0;
                if(operator=='*'){
                    res = stack.pop() * num;
                }
                else if(operator=='/'){
                    res = stack.pop() / num;
                }
                else if(operator=='-'){
                    res = num*-1;
                }
                else{
                    res = num;
                }

                stack.push(res);
            }
            else if(s.charAt(si)=='+' || s.charAt(si)=='-' ||
                    s.charAt(si)=='*' || s.charAt(si)=='/'){
                operator = s.charAt(si);
                si++;
            }
        }

        while(!stack.isEmpty()){
            result+=stack.pop();
        }

        return result;

    }

    //SC - O(1)

    /**
     * The approach works similar to Approach 1 with the following differences :
     *
     * Instead of using a stack, we use a variable lastNumber to track the value of the last evaluated expression.
     * If the operation is Addition (+) or Subtraction (-), add the lastNumber to the result instead of pushing it to the stack. The currentNumber would be updated to lastNumber for the next iteration.
     * If the operation is Multiplication (*) or Division (/), we must evaluate the expression lastNumber * currentNumber and update the lastNumber with the result of the expression. This would be added to the result after the entire string is scanned.
     * @param s
     * @return
     */
    public int calculate_o1(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}
