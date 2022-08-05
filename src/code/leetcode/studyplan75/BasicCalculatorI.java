package code.leetcode.studyplan75;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator/submissions/
//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=BjDczS5uQ-g
public class BasicCalculatorI {

    public int calculate(String s) {

        int curr = 0;
        int ans = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){

            if(Character.isDigit(s.charAt(i))){

                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    curr = curr*10 + s.charAt(i)-'0';
                    i++;
                }
                curr = curr*sign;
                ans = ans + curr;
                curr = 0;
                i--;
            }
            else if(s.charAt(i)=='+'){
                sign = 1;
            }
            else if(s.charAt(i)=='-'){
                sign = -1;
            }
            else if(s.charAt(i)=='('){
                st.push(ans);
                st.push(sign);
                ans = 0;
                sign = 1;
            }
            else if(s.charAt(i)==')'){
                int prevSign = st.pop();
                ans = ans * prevSign;
                int prevAns = st.pop();
                ans = ans + prevAns;
            }
        }

        return ans;
    }
}
