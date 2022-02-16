package code.google;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=GuTPwotSdYw
public class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,0,result);
        return result;
    }

    public static void permute(int nums[],int start,List<List<Integer>> result){
        if(start>=nums.length-1){
            List<Integer> temp = new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        for(int end=start;end<nums.length;end++){
            swap(nums,start,end);
            permute(nums,start+1,result);
            swap(nums,start,end);
        }
    }

    public static void swap(int nums[],int i1,int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
