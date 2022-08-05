package code.march.challenge;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String args[]){

        String path = "/home//foo";

        SimplifyPath obj = new SimplifyPath();

        System.out.println(obj.simplifyPath(path));
    }
    public String simplifyPath(String path) {

        if(path==null || path.length()==0){
            return null;
        }

        Stack<String> stack = new Stack<>();

        String tokens[] = path.split("/");

        for(String token:tokens){
            if("..".equals(token)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(".".equals(token) || token.isEmpty()){
                continue;
            }
            else if(token!=null && token.length()>0){
                stack.push(token);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String s:stack){
            sb.append("/");
            sb.append(s);
        }

        return sb.toString();
    }
}
