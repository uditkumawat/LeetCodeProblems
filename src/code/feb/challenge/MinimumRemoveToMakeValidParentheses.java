package code.feb.challenge;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//TC - O(n)
//SC- O(n)
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String args[]){

        String s = "lee(t(c)o)de)";

        MinimumRemoveToMakeValidParentheses obj = new MinimumRemoveToMakeValidParentheses();

        System.out.println(obj.minRemoveToMakeValid(s));
        System.out.println(obj.minRemoveToMakeValid("a)b(c)d"));
    }
    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();

        int bracket = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                bracket++;
            }
            else if(c==')'){
                //found invalid , no need to add in resultant string
                if(bracket==0){
                    continue;
                }
                bracket--;
            }

            sb.append(c);
        }

        StringBuilder res = new StringBuilder();

        for(int i=sb.length()-1;i>=0;i--){
            char c = sb.charAt(i);
            if(c=='(' && bracket-->0){
                continue;
            }
            res.append(c);
        }

        return res.reverse().toString();
    }
}
