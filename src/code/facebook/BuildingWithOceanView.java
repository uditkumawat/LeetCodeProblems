package code.facebook;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class BuildingWithOceanView {

    public static void main(String args[]){
        int arr[] = {1,3,2,4};
        BuildingWithOceanView obj = new BuildingWithOceanView();
        int res[] = obj.findBuildings(arr);
        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public int[] findBuildings(int[] heights) {

        if(heights==null || heights.length==0){
            return new int[0];
        }

        Set<Integer> res = new TreeSet<>();

        Stack<Integer> stack = new Stack<>();

        for(int i=heights.length-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()<heights[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                res.add(i);
            }

            stack.push(heights[i]);
        }

        int arr[] = new int[res.size()];

        int i=0;
        for(int num:res){
            arr[i++] = num;
        }

        return arr;
    }
}
