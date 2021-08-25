package code.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToLeft {

    public static void main(String args[]){

        int arr[] = {4,5,2,10,8};

        List<Integer> list = getList(arr);

        for(int n:list){
            System.out.print(n+" ");
        }
    }

    public static List<Integer> getList(int nums[]){
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){

            while(!stack.isEmpty() && stack.peek()>=nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                list.add(-1);
            }
            else{
                list.add(stack.peek());
            }

            stack.push(nums[i]);
        }
        return list;
    }
}
