package code.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */
public class NextGreaterElementI {

    public static void main(String args[]){

        NextGreaterElementI obj = new NextGreaterElementI();
        int nums1[] = {2,4};
        int nums2[] = {1,2,3,4};

        int ans[] = obj.nextGreaterElement(nums1,nums2);

        for(int num:ans){
            System.out.println(num+" ");
        }
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if(nums2==null || nums2.length==0){
            return new int[0];
        }

        Map<Integer,Integer> map  = getNextGreateElement(nums2);

        int ans[] = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;

    }

    public Map<Integer,Integer> getNextGreateElement(int nums[]){

        Stack<Integer> stack = new Stack<>();

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=nums.length-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()<nums[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(nums[i],-1);
            }
            else{
                map.put(nums[i],stack.peek());
            }

            stack.push(nums[i]);

        }

        return map;
    }
}
