package code.top100;

public class MinimumAddToMakeValidParentheses {

    public int minAddToMakeValid(String S) {
        int count = 0, stk = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                ++stk;
            }else if (stk <= 0) {
                ++count;
            }else {
                --stk;
            }
        }
        return count + stk;
    }
}
