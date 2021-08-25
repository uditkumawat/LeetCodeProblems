package code.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  the algorithm performs better than \mathcal{O}(N \times N!)O(N×N!) and a bit slower than \mathcal{O}(N!)O(N!).
 *
 * Space complexity : \mathcal{O}(N!)O(N!) since one has to keep N! solutions.
 */
public class Permutations {

    public static void main(String args[]){
        int arr[] = {1,2,3};
        List<List<Integer>> output = permute(arr);
        for(List<Integer> list:output){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        if(nums==null || nums.length==0){
            return output;
        }

        List<Integer> list = new ArrayList<>();

        for(int num:nums){
            list.add(num);
        }

        backtrack(list,output,0);

        return output;
    }

    public static void backtrack(List<Integer> nums, List<List<Integer>> output, int first){

        if(first==nums.size()){
            output.add(new ArrayList<Integer>(nums));
            return;
        }

        for(int i=first;i<nums.size();i++){
            Collections.swap(nums,first,i);
            backtrack(nums,output,first+1);
            Collections.swap(nums,first,i);
        }
    }

    public static void swap(int nums[],int start,int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
