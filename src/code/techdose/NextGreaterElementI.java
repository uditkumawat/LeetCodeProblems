package code.techdose;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
//TC - O(n+n)
//SC - O(n)
public class NextGreaterElementI {

    public static void main(String args[]){

        int nums1[] = {2,4};
        int nums2[] = {1,2,3,4};

        NextGreaterElementI obj = new NextGreaterElementI();

        int res[] = obj.nextGreaterElement(nums1,nums2);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int len = nums1.length;

        int res[] = new int[len];

        Stack<Integer> stack = new Stack<>();

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],stack.peek());
            }

            stack.push(nums2[i]);
        }

        for(int i=0;i<len;i++){
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
