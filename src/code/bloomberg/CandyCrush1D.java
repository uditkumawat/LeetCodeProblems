package code.bloomberg;

import java.util.Stack;

//https://leetcode.com/discuss/interview-question/380650/Bloomberg-or-Phone-or-Candy-Crush-1D
public class CandyCrush1D {

    public static void main(String args[]){

        CandyCrush1D obj = new CandyCrush1D();

        System.out.println(obj.crush("aaabbbc"));
        System.out.println(obj.crush("aabbbacd"));
        System.out.println(obj.crush("aabbccddeeedcba"));
        System.out.println(obj.crush("aaabbbacd"));
        System.out.println(obj.crush("aaabbbaac"));
    }

    class CountClass{
        char c;
        int freq;
        CountClass(char c){
            this.c = c;
            this.freq = 1;
        }
    }

    public String crush(String str){
        Stack<CountClass> stack = new Stack<>();

        for(char c:str.toCharArray()){
            if(stack.isEmpty() || stack.peek().c!=c){
                stack.push(new CountClass(c));
            }
            else if(!stack.isEmpty() && stack.peek().c==c){
                CountClass obj = stack.pop();
                obj.freq++;
                if(obj.freq<3){
                    stack.push(obj);
                }
                else {
                    while (!stack.isEmpty() && stack.peek().c==c){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop().c);
        }

        return sb.reverse().toString();
    }
}
