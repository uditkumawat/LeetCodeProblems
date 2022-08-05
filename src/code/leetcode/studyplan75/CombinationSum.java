package code.leetcode.studyplan75;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/submissions/
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList();
        if(candidates==null || candidates.length==0){
            return res;
        }

        helper(candidates,0,res,new ArrayList<Integer>(),target);

        return res;
    }

    public void helper(int nums[],int start,List<List<Integer>> res,List<Integer> temp, int target){

        if(target==0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if(target<0){
            return;
        }

        for(int end=start;end<nums.length;end++){
            temp.add(nums[end]);
            helper(nums,end,res,temp,target-nums[end]);
            temp.remove(temp.size()-1);
        }
    }
}
