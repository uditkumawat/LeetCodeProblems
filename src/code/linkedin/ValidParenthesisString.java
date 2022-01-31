package code.linkedin;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 */

/**
 * There is another simple O(n) solution with O(1) space complexity, not very intuitive like the greedy approach, but it's nice to know about it. We can rephrase the problem by listing all the valid cases. There are 3 valid cases:
 *
 * 1- There are more open parenthesis but we have enough '*' so we can balance the parenthesis with ')'
 * 2- There are more close parenthesis but we have enough '*' so we can balance the parenthesis with '('
 * 3- There are as many '(' than ')' so all parenthesis are balanced, we can ignore the extra '*'
 *
 * Algorithm: You can parse the String twice, once from left to right by replacing all '*' by '(' and once from right to left by replacing all '*' by ')'. For each of the 2 loops, if there's an iteration where you end up with a negative count (SUM['('] - SUM[')'] < 0) then you know the parenthesis were not balanced. You can return false. After these 2 checks (2 loops), you know the string is balanced because you've satisfied all the 3 valid cases mentioned above. Voila!
 */
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int leftBalance = 0;
        for (int i=0; i<s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '*'))
                leftBalance++;
            else
                leftBalance--;

            if (leftBalance<0) return false; // We know we have unbalanced parenthesis
        }

        // We can already check if parenthesis are valid
        if (leftBalance == 0) return true;

        int rightBalance = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if ((s.charAt(i) == ')') || (s.charAt(i) == '*'))
                rightBalance++;
            else
                rightBalance--;

            if (rightBalance<0) return false;  // We know we have unbalanced parenthesis
        }

        // Here we know we have never been unbalanced parsing from left to right e.g. ')('
        // We've also already substituted '*' either by '(' or by ')'
        // So we only have 3 possible scenarios here:
        // 1. We had the same amount of '(' and ')'
        // 2. We had more '(' then ')' but enough '*' to substitute
        // 3. We had more ')' then '(' but enough '*' to substitute
        return true;
    }

}
