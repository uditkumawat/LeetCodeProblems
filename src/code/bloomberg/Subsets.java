package code.bloomberg;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/submissions/
//https://www.youtube.com/watch?v=taIvqOIT3cM
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList();
        if(nums==null || nums.length==0){
            return res;
        }

        helper(nums,res,new ArrayList<Integer>(),0);
        return res;
    }

    public void helper(int nums[],List<List<Integer>> res,List<Integer> temp,int index){
        if(index==nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(nums[index]);
        helper(nums,res,temp,index+1);
        temp.remove(temp.size()-1);
        helper(nums,res,temp,index+1);
    }
}
