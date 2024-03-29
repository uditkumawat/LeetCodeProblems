package code.leetcodeTopInterviewQuestions;

import java.util.Stack;

//https://leetcode.com/problems/longest-valid-parentheses/submissions/
//TC - O(N)
//SC - O(N)
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
