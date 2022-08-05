package code.top100;

import java.util.HashSet;
import java.util.Stack;

//https://www.youtube.com/watch?v=thL70BR3yMA
//https://www.youtube.com/watch?v=qVBS4IUPeQg
public class MinimumRemoveToMakeValidParantheses {

    public String removeUnwanted(String str){

        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c:str.toCharArray()){
            if(c=='('){
                open++;
            }
            else if(c==')'){
                if(open==0){
                    continue;
                }
                open--;
            }
            sb.append(c);
        }

        StringBuilder res = new StringBuilder();
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='(' && open-->0){
                continue;
            }
            res.append(sb.charAt(i));
        }

        return res.reverse().toString();
    }

    //stack solution
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> openIndices = new Stack<>();
        HashSet<Integer> removeIndices = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                openIndices.push(i);
            else if (s.charAt(i) == ')') {
                if (openIndices.isEmpty())
                    removeIndices.add(i); // Meet closing-parentheses but no opening-parenthesis -> remove closing-parenthesis
                else
                    openIndices.pop();
            }
        }
        while (!openIndices.isEmpty())
            removeIndices.add(openIndices.pop()); // remove remain opening-parenthesis

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (!removeIndices.contains(i))
                stringBuilder.append(s.charAt(i));

        return stringBuilder.toString();
    }
}
