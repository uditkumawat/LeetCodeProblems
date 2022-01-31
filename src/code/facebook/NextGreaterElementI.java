package code.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//TC - O(nums1.length+nums2.length)
//SC - O(nums2.length)
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

        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

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

        int res[] = new int[nums1.length];
        int i=0;
        for(int num:nums1){
            res[i++] = map.get(num);
        }

        return res;
    }
}
