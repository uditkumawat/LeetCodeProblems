package code.facebook;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String args[]){

        String path = "/a/./b/../../c/";

        SimplifyPath obj = new SimplifyPath();

        System.out.println(obj.simplifyPath(path));

    }
    public String simplifyPath(String path) {

        if(path==null || path.length()==0){
            return null;
        }

        Stack<String> stack = new Stack<>();

        String components[] = path.split("/");

        for(String dir:components){

            if(dir.isEmpty() || dir.equals(".")){
                continue;
            }else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String str:stack){
            sb.append("/");
            sb.append(str);
        }

        return sb.toString();
    }
}
