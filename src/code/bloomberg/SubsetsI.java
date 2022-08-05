package code.bloomberg;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
//TC - O(n*2^n)
public class SubsetsI {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        subsets(nums,0,res,new ArrayList<>());

        return res;
    }

    public void subsets(int nums[],int start,List<List<Integer>> res,List<Integer> temp){


        if(start>=nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }


        temp.add(nums[start]);
        subsets(nums,start+1,res,temp);
        temp.remove(temp.size()-1);
        subsets(nums,start+1,res,temp);
    }
}
