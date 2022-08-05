package code.march.challenge;

import java.util.Stack;

//https://www.youtube.com/watch?v=zy7WmYm1KMo
//Tc - O(N)
//SC - O(N)
public class ScoreOfParantheses {

    public static void main(String args[]){

        String str = "(()(()()))";

        ScoreOfParantheses obj = new ScoreOfParantheses();

        System.out.println(obj.getScoreOfParantheses(str));

    }

    public int getScoreOfParantheses(String str){

        if(str==null || str.length()==0){
            return 0;
        }

        Stack<String> stack = new Stack<>();
        int res = 0;

        for(char c:str.toCharArray()){
            if(c=='('){
                stack.push(c+"");
            }
            else{
                if(c==')') {
                    int innerScore = 0;
                    while (!stack.isEmpty() && !stack.peek().equals("(")){
                        innerScore = innerScore + Integer.valueOf(stack.peek());
                        stack.pop();
                    }

                    stack.pop();
                    if(innerScore==0){
                        stack.push("1");
                    }
                    else{
                        stack.push(2*innerScore+"");
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            res = res + Integer.parseInt(stack.pop());
        }

        return res;
    }
}
