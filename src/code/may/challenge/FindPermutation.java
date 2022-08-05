package code.may.challenge;

import java.util.Stack;

public class FindPermutation {

    public static void main(String args[]){

        String s = "DDIIIIDI";

        FindPermutation obj = new FindPermutation();

        int res[] = obj.findPermutation(s);

        for(int num:res){
            System.out.print(num + " ");
        }
    }
    public int[] findPermutation(String s) {

        int nums[] = new int[s.length()+1];

        Stack<Integer> stack = new Stack<>();

        int resIndex = 0;

        for(int i=0;i<s.length();i++){

            int num = i+1;

            if(s.charAt(i)=='D'){
                stack.push(num);
            }
            else{
                stack.push(num);
                while(!stack.isEmpty()){
                    nums[resIndex++] = stack.pop();
                }
            }
        }

        stack.push(s.length()+1);
        while(!stack.isEmpty()){
            nums[resIndex++] = stack.pop();
        }

        return nums;
    }
}
